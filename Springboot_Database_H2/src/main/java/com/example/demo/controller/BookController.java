package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Books;
import com.example.demo.repo.BookRepo;
import com.example.demo.server.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	//@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	BookService bookService;

	/**
	 * Create New Book
	 * @param book
	 * @return 
	 * @return
	 */
	@PostMapping
	public  ResponseEntity<Books> addBook(@RequestBody Books book) {
		return 	bookService.addBook(book);
	}
	
	/**
	 * Get All books from the database
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<Books>> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	/**
	 * Get particular book by its id
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Books> getBookById(@PathVariable long id) {
		Optional<Books> book=bookRepo.findById(id);
		if(book.isPresent()) {
			return new ResponseEntity<>(book.get(),HttpStatus.OK);
		}else {
			return new ResponseEntity<Books> (HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * Get particular book by its id
	 * @param id
	 * @return
	 */
	@GetMapping("/bookname/name")
	public Books getBookByName(@RequestParam(value="name") String name) {
		
		return bookService.getBookByName(name);
		
	}
	
	/**
	 * Update the particular book information
	 * @param newbook
	 * @param id
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Books> updateBook(@RequestBody Books newbook,@PathVariable long id) {
		return bookService.updateBook(newbook, id);
	}
	
	/**
	 * Delete particular book
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Books> deletBook(@PathVariable long id){
		return bookService.deletBook(id);
	}

}
