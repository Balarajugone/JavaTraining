package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Books;

public interface BookRepo extends JpaRepository<Books, Long>{
	
	Books findByName(String name);

}
