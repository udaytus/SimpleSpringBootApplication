package com.example.ordermanagement;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ordermanagement.model.Customer;
import com.example.ordermanagement.repository.CustomerRepository;

@SpringBootTest
@Transactional
class CustomerTests {
  @Autowired
  private CustomerRepository customerRepository;

  @Test
  void testCreateCustomer() {
    Customer customer = new Customer();
    customer.setName("John Smith");
    customer.setEmail("john@example.com");
    customer.setCategory("regular");
    customer.setOrderCount(5);

    Customer savedCustomer = customerRepository.save(customer);
    assertNotNull(savedCustomer.getId());
    assertEquals("John Smith", savedCustomer.getName());
    assertEquals("john@example.com", savedCustomer.getEmail());
    assertEquals("regular", savedCustomer.getCategory());
    assertEquals(5, savedCustomer.getOrderCount());
  }

  @Test
  void testFindCustomerById() {
    Customer customer = new Customer();
    customer.setName("Jane Doe");
    customer.setEmail("jane@example.com");
    customer.setCategory("gold");
    customer.setOrderCount(10);
    customer = customerRepository.save(customer);

    Customer foundCustomer = customerRepository.findById(customer.getId()).orElse(null);
    assertNotNull(foundCustomer);
    assertEquals("Jane Doe", foundCustomer.getName());
    assertEquals("jane@example.com", foundCustomer.getEmail());
    assertEquals("gold", foundCustomer.getCategory());
    assertEquals(10, foundCustomer.getOrderCount());
  }

  
