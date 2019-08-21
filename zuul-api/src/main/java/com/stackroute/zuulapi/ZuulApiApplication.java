package com.stackroute.zuulapi;

import com.stackroute.zuulapi.pre.SimpleFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApiApplication.class, args);
	}

	@Bean
	public SimpleFilter simpleFilter(){
		return new SimpleFilter();
	}
}
