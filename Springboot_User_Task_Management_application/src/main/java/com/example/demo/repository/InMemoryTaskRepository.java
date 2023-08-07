package com.example.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.demo.ennum.PriorityLevel;
import com.example.demo.entity.Task;

@Repository
public class InMemoryTaskRepository implements TaskRepository{

	/**
	*A HashMap that stores tasks with their respective IDs as keys.
	*/
    private Map<Long, Task> tasks = new HashMap<>();
    
    /**
     * A counter to keep track of the next available task ID.
     */
    private Long idCounter = 1L;

    @Override
    public Task save(Task task) {
        if (task.getId() == null) {
            task.setId(idCounter++);
        }
        tasks.put(task.getId(), task);
        return task;
    }

    @Override
    public Task findById(Long id) {
        return tasks.get(id);
    }

    @Override
    public List<Task> findByProjectId(Long projectId) {
        return tasks.values().stream()
                .filter(task -> Objects.equals(task.getProjectId(), projectId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Task> findByPriority(PriorityLevel priority) {
        return tasks.values().stream()
                .filter(task -> task.getPriority() == priority)
                .collect(Collectors.toList());
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    public Task deleteById(Long id) {
       return tasks.remove(id);
    }
}
