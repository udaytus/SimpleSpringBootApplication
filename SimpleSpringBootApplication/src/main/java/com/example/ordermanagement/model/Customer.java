package com.example.ordermanagement.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customer {
	private Long id;
	  private String name;
	  private String email;
	  private String category;
	  private int orderCount;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public Customer(Long id, String name, String email, String category, int orderCount) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.category = category;
		this.orderCount = orderCount;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	  
}

