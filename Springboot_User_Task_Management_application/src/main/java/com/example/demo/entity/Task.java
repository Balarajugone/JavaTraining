package com.example.demo.entity;

import com.example.demo.ennum.PriorityLevel;

public class Task {
	
	private Long id;
	private String title;
	private String description;
	private String due_date;
	private PriorityLevel priority;
	private boolean completion_status;
	private Long projectId;
	
	
	public Task() {
		
	}

	public Task(Long id,String title, String description, String due_date, PriorityLevel priority, boolean completion_status,Long projectId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.due_date = due_date;
		this.priority = priority;
		this.completion_status = completion_status;
		this.projectId = projectId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDueDate() {
		return due_date;
	}

	public void setDueDate(String due_date) {
		this.due_date = due_date;
	}

	public PriorityLevel getPriority() {
		return priority;
	}
	public void setPriority(PriorityLevel priority) {
		this.priority = priority;
	}
	public boolean isCompletion_status() {
		return completion_status;
	}
	public void setCompletion_status(boolean completion_status) {
		this.completion_status = completion_status;
	}
	public Long getProjectId() {
		return projectId;
	}
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

}
