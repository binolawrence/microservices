/**
 * 
 */
package com.shopping.customer.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shopping.customer.entity.Customer;
import com.shopping.customer.service.CustomerService;

/**
 * @author 146374
 *
 */
@RefreshScope
@RequestMapping("/customerservice")
@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	RestTemplate restTemplate;
	
	@Value("${message: Default Message}")
	private String message;
	

	private static final String salesorderurl = "http://salesorder/customer";

	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable Long customerId) {
		return customerService.getCustomer(customerId);

	}

	@PostMapping("/customer")
	public Customer registerCustomer(@RequestBody Customer newCustomer) {
		saveCustomerinSalesOrder(newCustomer);
		return customerService.registerCustomer(newCustomer);

	}

	private Customer saveCustomerinSalesOrder(Customer customer) {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);
		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		// setting up the request body

		// request entity is created with request body and headers
		HttpEntity<Customer> requestEntity = new HttpEntity<>(customer, requestHeaders);

		ResponseEntity responseEntity = restTemplate.exchange(salesorderurl, HttpMethod.POST, requestEntity,
				Customer.class);

		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			System.out.println("Customer information saved in SOS database");
		}
		return customer;
	}
}