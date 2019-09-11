package com.stackroute.workflow;

import org.activiti.api.process.model.ProcessDefinition;
import org.activiti.api.process.model.ProcessInstance;
import org.activiti.api.process.model.builders.ProcessPayloadBuilder;
import org.activiti.api.process.runtime.ProcessRuntime;
import org.activiti.api.runtime.shared.query.Page;
import org.activiti.api.runtime.shared.query.Pageable;
import org.activiti.api.task.runtime.TaskRuntime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class WorkflowApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(WorkflowApplication.class);

	private final ProcessRuntime processRuntime;

	private final TaskRuntime taskRuntime;

	private final SecurityUtil securityUtil;

	public WorkflowApplication(ProcessRuntime processRuntime,
									  TaskRuntime taskRuntime,
									  SecurityUtil securityUtil) {
		this.processRuntime = processRuntime;
		this.taskRuntime = taskRuntime;
		this.securityUtil = securityUtil;
	}

	public static void main(String[] args) {
		SpringApplication.run(WorkflowApplication.class, args);

	}

	@Override
	public void run(String... args) {
		securityUtil.logInAs("system");

		Page<ProcessDefinition> processDefinitionPage = processRuntime.processDefinitions(Pageable.of(0, 10));
		logger.info("> Available Process definitions: " + processDefinitionPage.getTotalItems());
		for (ProcessDefinition pd : processDefinitionPage.getContent()) {
			logger.info("\t > Process definition: " + pd);
		}
		createProcessInstance("designer_workflow");
		createProcessInstance("supplier_workflow");
		createProcessInstance("manufacturer_workflow");
	}



	public void createProcessInstance(String process) {

		securityUtil.logInAs("system");

		logger.info("> Starting process ");//: " + content + " at " + formatter.format(new Date()));

		ProcessInstance processInstance = processRuntime.start(ProcessPayloadBuilder
				.start()
				.withProcessDefinitionKey(process)
				.build());
		logger.info(">>> Created Process Instance: " + processInstance);

	}

}
