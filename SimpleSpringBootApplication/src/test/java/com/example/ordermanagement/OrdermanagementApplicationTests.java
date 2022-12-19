package com.example.ordermanagement;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ordermanagement.model.Customer;

@SpringBootTest
class OrdermanagementApplicationTests {

	@Test
	void contextLoads() {
	}
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

	    Customer foundCustomer = customerRepository.findById(customer.getId());
	    assertNotNull(foundCustomer);
	    assertEquals("Jane Doe", foundCustomer.getName());
	    assertEquals("jane@example.com", foundCustomer.getEmail());
	    assertEquals("gold", foundCustomer.getCategory());
	    assertEquals(10, foundCustomer.getOrderCount());
	  }

}
