package com.demo.campaign.management.ms.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
@Component
@Document(collection="Category")
public class Category {
	private String categoryValue;

	/**
	 * 
	 */
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param categoryValue
	 */
	public Category(String categoryValue) {
		super();
		this.categoryValue = categoryValue;
	}

	/**
	 * @return the categoryValue
	 */
	public String getCategoryValue() {
		return categoryValue;
	}

	/**
	 * @param categoryValue the categoryValue to set
	 */
	public void setCategoryValue(String categoryValue) {
		this.categoryValue = categoryValue;
	}

	@Override
	public String toString() {
		return "Category [categoryValue=" + categoryValue + "]";
	}
	
	
}
