package com.javatraining.assignment9;

import java.util.ArrayList;
import java.util.List;

public class Books {
	
	private static Books instance;
	List<Book>books;
	
	private Books() {
		books=new ArrayList<>();
	}
 
	public static Books getInstance() {
		if(instance==null) {
			instance=new Books();
		}
		return instance;
		
	}
	
	public void addBooks(Book book) {
		books.add(book);
		
	}
	public void removeBooks(Book book) {
		books.remove(book);
	}
	public void updateBooks(int index,Book book) {
		books.set(index, book);
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	public Book bookAuthorise(Book b) {
		for(Book book:books) {
			if(book.getbName().equals(b.getbName()) && book.getbAuthor().equals(b.getbAuthor()) &&  book.getbCost()==(b.getbCost())) {
				return book;
			}
		}
		return null;
	}
}
