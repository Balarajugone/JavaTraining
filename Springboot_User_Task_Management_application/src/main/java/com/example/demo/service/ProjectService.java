package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Project;

@Service
public interface ProjectService {

	public Project createProject(Project project);

	public Project updateProject(Long projectId, Project project);

	public Project getProjectId(Long projectId);

	public List<Project> getAllProjects();

	public Project deleteProject(Long projectId);
}
