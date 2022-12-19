package com.example.ordermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ordermanagement.model.Customer;
import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.repository.CustomerRepository;
import com.example.ordermanagement.repository.OrderRepository;

@Service
public class OrderService {
  private final CustomerRepository customerRepository;
  private final OrderRepository orderRepository;

  @Autowired
  public OrderService(CustomerRepository customerRepository, OrderRepository orderRepository) {
    this.customerRepository = customerRepository;
    this.orderRepository = orderRepository;
  }

  public Order createOrder(Long customerId, double discount) {
    Customer customer = customerRepository.findById(customerId).orElse(null);
    int orderCount = customer.getOrderCount() + 1;
    customer.setOrderCount(orderCount);
    if (orderCount >= 20) {
      customer.setCategory("platinum");
    } else if (orderCount >= 10) {
      customer.setCategory("gold");
    }
    customerRepository.save(customer);

    Order order = new Order();
    order.setCustomer_id(customer);
    order.setDiscount(discount);
    return orderRepository.save(order);
  }

  public double getDiscount(Long customerId) {
    Customer customer = customerRepository.findById(customerId).orElse(null);
    if (customer.getCategory().equals("gold")) {
      return 0.1;
    } else if (customer.getCategory().equals("platinum")) {
      return 0.2;
    } else {
      return 0;
    }
  }
}
