package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Books;
import com.example.demo.repo.BookRepo;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookRepo bookRepo;

	/**
	 * Create New Book
	 * @param book
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Books> addBook(@RequestBody Books book) {
		return 	new ResponseEntity<Books> (bookRepo.save(book),HttpStatus.CREATED)	;
	}
	
	/**
	 * Get All books from the database
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Books>> getAllBooks() {
		return new ResponseEntity<List<Books>>(bookRepo.findAll(),HttpStatus.OK);
	}
	
	/**
	 * Get perticular book by its id
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Books> getBook(@PathVariable long id) {
		Optional<Books> book=bookRepo.findById(id);
		if(book.isPresent()) {
			return new ResponseEntity<>(book.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<Books> (HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Update the perticular book information
	 * @param newbook
	 * @param id
	 * @return
	 */
	@PutMapping("/{id}")
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
	
	/**
	 * Delet perticular book
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Books> deletBook(@PathVariable long id){
		Optional<Books> book=bookRepo.findById(id);
		if(book.isPresent()) {
		bookRepo.deleteById(id);
		return new ResponseEntity<Books>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<Books>(HttpStatus.NOT_FOUND);
		}
	}

}
