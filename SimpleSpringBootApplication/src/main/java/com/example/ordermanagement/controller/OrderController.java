package com.example.ordermanagement.controller;


import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.objectclass.OrderRequest;
import com.example.ordermanagement.repository.OrderRepository;
import com.example.ordermanagement.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/order")
/*public class orderController {
   private final OrderService orderService;
    @Autowired
    public OrderController(OrderService orderService) {
      this.orderService = orderService;
    }
    @PostMapping("/placeOrder")
    public ResponseEntity<Order> createOrder(@RequestBody Order request) {
        Order order = orderService.createOrder(request.getCustomer_id(), request.getDiscount());
        return ResponseEntity.ok(order);
    }
    @GetMapping("/getOrderDetails/{order_id}")
    public Optional<Order> getOrder(@PathVariable Long order_id){
        return orderRep.findById(order_id);
    }
}
*/
public class OrderController {
private final OrderService orderService;

@Autowired
public OrderController(OrderService orderService) {
  this.orderService = orderService;
}

@PostMapping
public Order createOrder(@RequestBody OrderRequest request) {
  return orderService.createOrder(request.getCustomerId(), request.getDiscount());
}

@GetMapping("/{customerId}/discount")
public double getDiscount(@PathVariable Long customerId) {
  return orderService.getDiscount(customerId);
}
}