package com.stackroute.onlinefashionretail.designer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DesignerDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignerDashboardApplication.class, args);
	}

}
