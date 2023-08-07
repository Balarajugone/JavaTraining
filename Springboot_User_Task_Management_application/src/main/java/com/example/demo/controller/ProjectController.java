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

import com.example.demo.entity.Project;
import com.example.demo.service.ProjectService;

@RestController
@RequestMapping(value = "/api/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	/**
	 * Creates a new project
	 * 
	 * @param 
	 * @return Return the Project details and status as created
	 * 
	 */
	@PostMapping()
	public ResponseEntity<Project> saveProject(@RequestBody Project project) {
		Project addProject = projectService.createProject(project);
		return new ResponseEntity<Project>(addProject, HttpStatus.CREATED);
	}

	/**
	 * Update the existing project
	 * 
	 * @param 
	 * @return Return the project details if exist and status as OK
	 */
	@PutMapping(value = "/{projectId}")
	public ResponseEntity<Project> updateProject(@PathVariable(value = "projectId") Long projectId,
			@RequestBody Project project) {
		Project existingProject = projectService.updateProject(projectId, project);
		return new ResponseEntity<Project>(existingProject, HttpStatus.OK);
	}

	/**
	 * Retrieves a project by ID.
	 * 
	 * @param 
	 * @return 
	 */
	@GetMapping(value = "/{projectId}")
	public ResponseEntity<Project> getProject(@PathVariable(value = "projectId") Long projectId) {
		Project getExistingProject = projectService.getProjectId(projectId);
		if (getExistingProject != null) {
			return new ResponseEntity<Project>(getExistingProject, HttpStatus.OK);
		} else {
			return new ResponseEntity<Project>(getExistingProject, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 *  Deletes a project with projectId.
	 *  
	 * @param 
     * @return 
	 */
	@DeleteMapping(value = "/{projectId}")
	public ResponseEntity<Void> deleteProject(@PathVariable(value = "projectId") Long projectId) {
		Project project = projectService.deleteProject(projectId);
		if(project!=null) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
    
	/**
	 * Retrieves all the projects from the list
	 * 
	 * @return  
	 */
	@GetMapping()
	public ResponseEntity<List<Project>> getAllProjects() {
		List<Project> projects = projectService.getAllProjects();
		return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
	}
}
