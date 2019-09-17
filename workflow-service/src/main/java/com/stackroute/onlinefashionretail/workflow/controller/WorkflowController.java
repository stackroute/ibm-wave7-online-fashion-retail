package com.stackroute.onlinefashionretail.workflow.controller;

import com.stackroute.onlinefashionretail.workflow.RandomIdGenerator;
import com.stackroute.onlinefashionretail.workflow.exception.ApiCallException;
import com.stackroute.onlinefashionretail.workflow.models.*;
import com.stackroute.onlinefashionretail.workflow.SecurityUtil;
import com.stackroute.onlinefashionretail.workflow.models.Mapping;
import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.ProcessInstanceMeta;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.model.Task;
import org.activiti.api.task.model.builders.TaskPayloadBuilder;
import org.activiti.api.task.runtime.TaskAdminRuntime;
import org.activiti.api.task.runtime.TaskRuntime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "api/v1")
public class WorkflowController {

    private String DESIGNER_IP = "localhost:8187";
    private String SUPPLIER_IP = "localhost:8188";
    private String MANUFACTURER_IP = "localhost:8189";
    private String CONSUMER_IP = "localhost:8190";
    private String USER_IP = "localhost:8192";

   // private String DESIGNER_IP = "13.126.224.142:8187";
   // private String SUPPLIER_IP = "13.126.224.142:8188";
   // private String MANUFACTURER_IP = "13.126.224.142:8189";
   // private String CONSUMER_IP = "13.126.224.142:8190";
   // private String USER_IP = "13.126.224.142:8192";

    private String DESIGNER_RESOURCE_URL = "http://" + DESIGNER_IP + "/api/v1/designs";
    private String SUPPLIER_RESOURCE_URL = "http://" + SUPPLIER_IP + "/api/v1/material";
    private String MANUFACTURER_RESOURCE_URL = "http://" + MANUFACTURER_IP + "/api/v1/baseprice";

    private Logger logger = LoggerFactory.getLogger(WorkflowController.class);

    private final ProcessRuntime processRuntime;

    private final TaskRuntime taskRuntime;

    private final TaskAdminRuntime taskAdminRuntime;

    private final SecurityUtil securityUtil;

    private HttpHeaders headers = new HttpHeaders();

    private HttpEntity entity;

    @Autowired
    public WorkflowController(ProcessRuntime processRuntime, TaskRuntime taskRuntime, TaskAdminRuntime taskAdminRuntime, SecurityUtil securityUtil) {
        this.processRuntime = processRuntime;
        this.taskRuntime = taskRuntime;
        this.taskAdminRuntime = taskAdminRuntime;
        this.securityUtil = securityUtil;
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @PostMapping("upload")
    public ResponseEntity<?> uploadDesign(@RequestBody DesignerOrder designerOrder, @RequestParam String designerName) throws ApiCallException {
        logger.info("< upload design handler");
        String id = claimTask("Upload Design");

        //RestTemplate gets response from an api
        RestTemplate restTemplate = new RestTemplate();
        logger.info("url: "+DESIGNER_RESOURCE_URL);
        List<SupplierOrder> supplierOrders = new ArrayList<SupplierOrder>();
        for (Map<String, Double> mappings:
             designerOrder.getSupplierList()) {
            supplierOrders.add(new SupplierOrder(RandomIdGenerator.getRandomId(),
                    designerName,
                    new Material(),
                    mappings.get(""),"in-progress",""))
        }
        SupplierOrder supplierOrder =
        //store response in a ResponseEntity
        entity = new HttpEntity<>(designerOrder, headers);
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);

        try {
           responseEntity  = restTemplate.exchange(
                    DESIGNER_RESOURCE_URL,
                    HttpMethod.POST,
                    entity,
                    DesignerOrder.class);
        }
        catch (Exception e){
            logger.error("In exception block");
            throw new ApiCallException(e.getMessage(),e.getCause());
        }

        finally {
            logger.info("> response: " + responseEntity.getBody() );
            // Let's complete the task
            completeTask(id);
            startProcess("designer_workflow");

        }
        return responseEntity;
    }

    @PostMapping("add-material")
    public ResponseEntity<?> addMaterial(@RequestBody Mapping mapping) throws ApiCallException {
        String id = claimTask("Add Material");

        //RestTemplate gets response from an api
        RestTemplate restTemplate = new RestTemplate();

        //store response in a ResponseEntity
        entity = new HttpEntity<>(mapping, headers);
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);

        try {
            responseEntity  = restTemplate.exchange(
                    SUPPLIER_RESOURCE_URL,
                    HttpMethod.POST,
                    entity,
                    String.class);
        }
        catch (Exception e){
            logger.error("In exception block");
            throw new ApiCallException(e.getMessage(),e.getCause());
        }

        finally {
            logger.info("> response: " + responseEntity.getBody() );
            // Let's complete the task
            completeTask(id);
            startProcess("supplier_workflow");

        }
        return responseEntity;
    }

    @PostMapping("manufacturer")
    public ResponseEntity<?> registerUser(@RequestBody BasePrice basePrice) throws ApiCallException {
        String id = claimTask("Add Baseprice");

        //RestTemplate gets response from an api
        RestTemplate restTemplate = new RestTemplate();

        //store response in a ResponseEntity
        entity = new HttpEntity<>(basePrice, headers);
        ResponseEntity responseEntity = new ResponseEntity(HttpStatus.OK);

        try {
            responseEntity  = restTemplate.exchange(
                    MANUFACTURER_RESOURCE_URL,
                    HttpMethod.POST,
                    entity,
                    String.class);
        }
        catch (Exception e){
            logger.error("In exception block");
            throw new ApiCallException(e.getMessage(),e.getCause());
        }

        finally {
            logger.info("> response: " + responseEntity.getBody() );
            // Let's complete the task
            completeTask(id);
            startProcess("manufacturer_workflow");

        }
        return responseEntity;
    }

    @GetMapping("/process-definitions")
    public List<ProcessDefinition> getProcessDefinitions() {
        securityUtil.logInAs("system");
        Page<ProcessDefinition> processDefinitionPage = processRuntime.processDefinitions(Pageable.of(0, 10));
        logger.info("> Available Process definitions: " + processDefinitionPage.getTotalItems());

        for (ProcessDefinition pd : processDefinitionPage.getContent()) {
            logger.info("\t > Process definition: " + pd);
        }

        return processDefinitionPage.getContent();
    }

    @RequestMapping("/start-process")
    public ProcessInstance startProcess(
            @RequestParam(value = "processDefinitionKey", defaultValue = "SampleProcess") String processDefinitionKey) {
        securityUtil.logInAs("system");
        ProcessInstance processInstance = processRuntime.start(ProcessPayloadBuilder
                .start()
                .withProcessDefinitionKey(processDefinitionKey)
                .build());
        logger.info(">>> Created Process Instance: " + processInstance);

        return processInstance;
    }

    @GetMapping("/my-tasks")
    public List<Task> getMyTasks() {
        securityUtil.logInAs("salaboy");
        Page<Task> tasks = taskRuntime.tasks(Pageable.of(0, 10));
        logger.info("> My Available Tasks: " + tasks.getTotalItems());

        for (Task task : tasks.getContent()) {
            logger.info("\t> My User Task: " + task);
        }

        return tasks.getContent();
    }

    @GetMapping("/all-tasks")
    public List<Task> getAllTasks() {
        securityUtil.logInAs("admin");
        Page<Task> tasks = taskAdminRuntime.tasks(Pageable.of(0, 10));
        logger.info("> All Available Tasks: " + tasks.getTotalItems());

        for (Task task : tasks.getContent()) {
            logger.info("\t> User Task: " + task);
        }

        return tasks.getContent();
    }

    @GetMapping("/process-instances")
    public List<ProcessInstance> getProcessInstances() {
        securityUtil.logInAs("system");

        return processRuntime.processInstances(Pageable.of(0, 10)).getContent();
    }

    @GetMapping("/process-instance-meta")
    public ProcessInstanceMeta getProcessInstanceMeta(@RequestParam(value = "processInstanceId") String processInstanceId) {
        securityUtil.logInAs("system");
        return processRuntime.processInstanceMeta(processInstanceId);
    }

    private String claimTask(String taskName) {
        securityUtil.logInAs("salaboy");

        Page<Task> tasks = taskRuntime.tasks(Pageable.of(0, 10));
        String availableTaskId = "";
        for (Task t : tasks.getContent()
        ) {
            if (t.getName().equals(taskName))
                availableTaskId = t.getId();
        }
        // Let's claim the task, after the claim, nobody else can see the task and 'erdemedeiros' becomes the assignee
        logger.info("> Claiming the task");
        taskRuntime.claim(TaskPayloadBuilder.claim().withTaskId(availableTaskId).build());
        return availableTaskId;
    }

    private void completeTask(String availableTaskId) {
        logger.info("> Completing the task");
        securityUtil.logInAs("salaboy");
        taskRuntime.complete(TaskPayloadBuilder.complete().withTaskId(availableTaskId).build());
    }
}

