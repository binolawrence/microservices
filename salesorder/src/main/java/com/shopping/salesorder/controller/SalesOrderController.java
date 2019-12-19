/**
 * 
 */
package com.shopping.salesorder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.shopping.salesorder.entity.Customer;
import com.shopping.salesorder.entity.OrderLineItem;
import com.shopping.salesorder.entity.SalesOrder;
import com.shopping.salesorder.repository.CustomerRepository;
import com.shopping.salesorder.repository.SalesOrderRepository;

/**
 * @author bino
 *
 */
public class SalesOrderController {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	SalesOrderRepository salesOrderRepository;
	
	@PostMapping("/customer")
	public ResponseEntity registerCustomer(@RequestBody Customer newCustomer) {
		//String greeting = this.restTemplate.getForObject("http://localhost:8090/greeting", String.class);
		customerRepository.save(newCustomer);
		return new ResponseEntity(HttpStatus.CREATED);
		
	}
	
	@PostMapping("/salesorder")
	public SalesOrder createOrder(@RequestBody SalesOrder sorder) {
		//String greeting = this.restTemplate.getForObject("http://localhost:8090/greeting", String.class);
		return salesOrderRepository.save(sorder);
		
	}
}
