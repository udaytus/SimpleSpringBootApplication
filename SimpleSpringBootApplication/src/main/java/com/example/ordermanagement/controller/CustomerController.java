package com.example.ordermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ordermanagement.model.Customer;
import com.example.ordermanagement.objectclass.CategoryRequest;
import com.example.ordermanagement.objectclass.CustomerRequest;
import com.example.ordermanagement.repository.CustomerRepository;


public class CustomerController {
	  private final CustomerRepository customerRepository;

	  @Autowired
	  public CustomerController(CustomerRepository customerRepository) {
	    this.customerRepository = customerRepository;
	  }

	  @PostMapping
	  public Customer createCustomer(@RequestBody CustomerRequest request) {
	    Customer customer = new Customer();
	    customer.setName(request.getName());
	    customer.setEmail(request.getEmail());
	    customer.setCategory("regular");
	    return customerRepository.save(customer);
	  }

	  @PutMapping("/{customerId}/category")
	  public Customer updateCategory(@PathVariable Long customerId, @RequestBody CategoryRequest request) {
	    Customer customer = customerRepository.findById(customerId).orElse(null);
	    customer.setCategory(request.getCategory());
	    return customerRepository.save(customer);
	  }
	}
