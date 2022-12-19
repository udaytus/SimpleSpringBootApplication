package com.example.ordermanagement.objectclass;

public class OrderRequest {
private Long customerId;
private double discount;
public Long getCustomerId() {
	return customerId;
}
public void setCustomerId(Long customerId) {
	this.customerId = customerId;
}
public double getDiscount() {
	return discount;
}
public void setDiscount(double discount) {
	this.discount = discount;
}
public OrderRequest() {
	super();
	// TODO Auto-generated constructor stub
}
public OrderRequest(Long customerId, double discount) {
	super();
	this.customerId = customerId;
	this.discount = discount;
}
}
