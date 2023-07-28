package com.javatraining.assignment9;

public class Book {
	
	String bName;
	String bAuthor;
	double bcost;
	
	public Book(String bName,String bAuthor,double bcost) {
		this.bName=bName;
		this.bAuthor=bAuthor;
		this.bcost=bcost;
	}

	public String getbName() {
		return bName;
	}

	public String getbAuthor() {
		return bAuthor;
	}

	public double getbCost() {
		return bcost;
	}

	public String toString() {
		return bName+" "+bAuthor+" "+bcost;
		
	}
}
