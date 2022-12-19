package com.example.ordermanagement.objectclass;

public class CategoryRequest {
	  private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public CategoryRequest(String category) {
		super();
		this.category = category;
	}

	public CategoryRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
}