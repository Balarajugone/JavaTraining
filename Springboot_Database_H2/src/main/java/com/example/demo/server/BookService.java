package com.example.demo.server;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Books;
import com.example.demo.repo.BookRepo;

@Service
public class BookService {
	
	@Autowired
	BookRepo bookRepo;
	
	public ResponseEntity<Books> addBook(@RequestBody Books book) {
		return 	new ResponseEntity<Books> (bookRepo.save(book),HttpStatus.CREATED)	;
	}
	
	public ResponseEntity<List<Books>> getAllBooks() {
		return new ResponseEntity<List<Books>>(bookRepo.findAll(),HttpStatus.OK);
	}
	
	public ResponseEntity<Books> updateBook(@RequestBody Books newbook,@PathVariable long id) {
		Optional<Books> book=bookRepo.findById(id);
		if(book.isPresent()) {
			Books oldbook = book.get();
			oldbook.setBookName(newbook.getBookName());
			oldbook.setBookAuthor(newbook.getBookAuthor());
			oldbook.setBookDescription(newbook.getBookDescription());
			oldbook.setBookPrice(newbook.getBookPrice());
			return new ResponseEntity<> (bookRepo.save(oldbook),HttpStatus.OK);
		}else {
			return new ResponseEntity<> (HttpStatus.NOT_FOUND);
		}
	}
	
	public ResponseEntity<Books> deletBook(@PathVariable long id){
		Optional<Books> book=bookRepo.findById(id);
		if(book.isPresent()) {
		bookRepo.deleteById(id);
		return new ResponseEntity<Books>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<Books>(HttpStatus.NOT_FOUND);
		}
	}
	
	public Books getBookByName(String bookName) {
		Books getBookName = bookRepo.findByName(bookName);
		if (getBookName != null) {
			return getBookName;
		}
		return null;
	}

}
