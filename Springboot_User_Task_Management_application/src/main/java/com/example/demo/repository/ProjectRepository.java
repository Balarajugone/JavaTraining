package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entity.Project;

@Repository
public interface ProjectRepository {

	public Project save(Project project);

	public Project findById(Long id);

	public List<Project> findAll();

	public Project deleteById(Long id);
}
