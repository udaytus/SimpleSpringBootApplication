package com.example.ordermanagement.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
 public class Order {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      @ManyToOne
      @JoinColumn(name = "Customer_id")
      private Customer Customer_id;

      private double discount;

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Customer getCustomer_id() {
		return Customer_id;
	}

	public void setCustomer_id(Customer customer) {
		this.Customer_id = customer;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public Order(Long id, Customer Customer_id, double discount) {
		super();
		this.id = id;
		this.Customer_id = Customer_id;
		this.discount = discount;
	}
	
}