package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.ennum.PriorityLevel;
import com.example.demo.entity.Task;

@Service
public interface TaskService {

	public Task createTask(Task task);

	public Task updateTask(Long id, Task task);

	public Task getTaskId(Long id);

	public List<Task> getPriorityTask(PriorityLevel priorityLevel);

	public List<Task> getAllTask();

	public void markTaskAsCompleted(Long id);

	public Task deleteTask(Long id);
}
