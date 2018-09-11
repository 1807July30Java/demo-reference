package com.revature.beans;

import java.io.Serializable;

public class Category implements Serializable {

	public Category(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Category(String name) {
		super();
		this.name = name;
	}
	
	public Category() {
		super();
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = -4505332504426261530L;
	
	private int id;
	
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}
}