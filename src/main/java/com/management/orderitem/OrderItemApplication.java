package com.management.orderitem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@SpringBootApplication
@EnableHystrix
@EnableHystrixDashboard
@EnableEurekaClient
public class OrderItemApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(OrderItemApplication.class, args);
	}

}
