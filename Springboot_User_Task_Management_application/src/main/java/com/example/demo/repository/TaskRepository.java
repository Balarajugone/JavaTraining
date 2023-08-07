package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.ennum.PriorityLevel;
import com.example.demo.entity.Task;

@Repository
public interface TaskRepository {

	public Task save(Task task);

	public Task findById(Long id);

	public List<Task> findByProjectId(Long projectId);

	public List<Task> findByPriority(PriorityLevel priority);

	public List<Task> findAll();

	public Task deleteById(Long id);
}
