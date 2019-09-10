package com.stackroute.workflow.controller;

import com.stackroute.workflow.SecurityUtil;
import com.stackroute.workflow.models.*;
import com.stackroute.workflow.models.Mapping;
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
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("activiti")
public class WorkflowController {

    private String DESIGNER_IP = "172.23.238.222";
    private String SUPPLIER_IP = "172.23.238.218";
    private String USER_IP = "172.23.238.222";
    private String MANUFACTURER_IP = "";
    private String CONSUMER_IP = "";

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
    public ResponseEntity<?> uploadDesign(@RequestBody DesignerOrder designerOrder) {
        logger.info("< upload design handler");
        String id = claimTask("Upload Design");

        //RestTemplate gets response from an api
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://" + DESIGNER_IP + ":8080/designs";
        logger.info("url: "+fooResourceUrl);

        //store response in a ResponseEntity
        entity = new HttpEntity<>(designerOrder, headers);


        //ResponseEntity responseEntity = restTemplate.postForEntity( fooResourceUrl, designerOrder, Dorder.class);
        ResponseEntity responseEntity = restTemplate.exchange(
                fooResourceUrl,
                HttpMethod.POST,
                entity,
                DesignerOrder.class);

        logger.info("> response: " + responseEntity.getBody() );
        // Let's complete the task
        completeTask(id);
//        entity = new HttpEntity<>(designerOrder, headers);
//        try{
//            restTemplate.exchange(
//                    "http://" + SUPPLIER_IP + "/designs",
//                    HttpMethod.POST,
//                    entity,
//                    new ParameterizedTypeReference<Dorder>() {
//                    });
//        }catch (Exception e){
//            logger.error(e.getMessage(),e);
//        }
        startProcess("designer_workflow");
        return responseEntity;

    }

    @PostMapping("add-material")
    public ResponseEntity<?> addMaterial(@RequestBody Mapping mapping) {
        String id = claimTask("Add a Material");

        //RestTemplate gets response from an api
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://" + SUPPLIER_IP + ":8089/material";

        //store response in a ResponseEntity
        entity = new HttpEntity<>(mapping, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                fooResourceUrl,
                HttpMethod.POST,
                entity,
                String.class);

        //ResponseEntity responseEntity = restTemplate.postForEntity( fooResourceUrl, dorder, Dorder.class);

        logger.info("> response: " + responseEntity);
        // Let's complete the task
        completeTask(id);
        startProcess("supplier_workflow");
        return responseEntity;
    }

    @GetMapping("register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        String id = claimTask("Register User");

        //RestTemplate gets response from an api
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://" + USER_IP + ":8088/user";

        //store response in a ResponseEntity
        entity = new HttpEntity<>(user, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                fooResourceUrl,
                HttpMethod.POST,
                entity,
                String.class);
        
        logger.info("> response: " + responseEntity);
        // Let's complete the task
        completeTask(id);
        startProcess("user_service_workflow");
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

