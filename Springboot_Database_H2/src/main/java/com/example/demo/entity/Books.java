package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Books {
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String bookAuthor;
	private String bookDescription;
	private double bookPrice;
	
	public Books() {
		
	}
	
	

	public Books(long id, String name, String bookAuthor, String bookDescription, double bookPrice) {
		super();
		this.id = id;
		this.name = name;
		this.bookAuthor = bookAuthor;
		this.bookDescription = bookDescription;
		this.bookPrice = bookPrice;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBookName() {
		return name;
	}

	public void setBookName(String name) {
		this.name = name;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	
	
	

}
