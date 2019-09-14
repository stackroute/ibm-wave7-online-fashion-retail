
package com.stackroute.onlinefashionretail.manufacturer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ManufactureApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManufactureApplication.class, args);
	}

}
