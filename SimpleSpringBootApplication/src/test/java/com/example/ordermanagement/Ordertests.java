package com.example.ordermanagement;

import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.ordermanagement.model.Customer;
import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.repository.CustomerRepository;
import com.example.ordermanagement.repository.OrderRepository;

@SpringBootTest
@Transactional
class OrderTests {
  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private OrderRepository orderRepository;

  @Test
  void testCreateOrder() {
    Customer customer = new Customer();
    customer.setName("John Smith");
    customer.setEmail("john@example.com");
    customer.setCategory("regular");
    customer.setOrderCount(5);
    customer = customerRepository.save(customer);

    Order order = new Order();
    order.setCustomer_id(customer);
    order.setDiscount(0.1);

    Order savedOrder = orderRepository.save(order);
    assertNotNull(savedOrder.getId());
    assertEquals(customer, savedOrder.getCustomer_id());
    assertEquals(0.1, savedOrder.getDiscount(), 0.001);
  }
  
}