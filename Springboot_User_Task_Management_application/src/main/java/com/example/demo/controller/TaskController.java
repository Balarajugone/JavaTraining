package com.example.demo.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;

	/**
	 * Creates a new Task
	 * 
	 * @param 
	 * @return 
	 */
	@PostMapping
	public ResponseEntity<Task> saveTask(@RequestBody Task task) {
		Task tasks = taskService.createTask(task);
		return new ResponseEntity<>(tasks, HttpStatus.CREATED);
	}

	/**
	 * Update the existing Task
	 * 
	 * @param Id, 
	 * @return 
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Task> updateTask(@PathVariable(value = "id") Long id, @RequestBody Task task) {
		Task existingTask = taskService.updateTask(id, task);
		if (existingTask != null) {
			return new ResponseEntity<Task>(existingTask, HttpStatus.OK);
		} else {
			return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Retrieves a task by ID.
	 * 
	 * @param 
	 * @return Return the task details if found 
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Task> getTask(@PathVariable(value = "id") Long id) {
		Task taskId = taskService.getTaskId(id);
		if (taskId != null) {
			return new ResponseEntity<Task>(taskId, HttpStatus.OK);
		} else {
			return new ResponseEntity<Task>(taskId, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/taskDetails/{id}")
	public ResponseEntity<Void> markTaskAsCompleted(@PathVariable(value = "id") Long id) {
		taskService.markTaskAsCompleted(id);
		return ResponseEntity.ok().build();

	}

	/**
	 *  Deletes a task with id.
	 *  
	 * @param 
     * @return 
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable(value = "id") Long id) {
		Task task = taskService.deleteTask(id);
		if(task!=null) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}

	/**
	 * Retrieves all the tasks from the list
	 * 
	 * @return  
	 */
	@GetMapping()
	public ResponseEntity<List<Task>> getAllTask() {
		List<Task> tasks = taskService.getAllTask();
		return new ResponseEntity<>(tasks, HttpStatus.OK);
	}
}
