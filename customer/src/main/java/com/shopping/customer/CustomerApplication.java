package com.shopping.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.shopping.customer.configuratiion.SalesOrderConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "salesorder", configuration = SalesOrderConfiguration.class)
public class CustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
