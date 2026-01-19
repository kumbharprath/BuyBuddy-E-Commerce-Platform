package com.example.buy_buddy_customer_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BuyBuddyCustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyBuddyCustomerServiceApplication.class, args);
	}

}
