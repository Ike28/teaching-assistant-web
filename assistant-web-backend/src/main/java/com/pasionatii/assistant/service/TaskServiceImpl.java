package com.pasionatii.assistant.service;

import com.pasionatii.assistant.entity.Task;
import com.pasionatii.assistant.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TaskServiceImpl implements TaskService{

    @Autowired
    private ITaskRepository taskRepository;

    @Override
    public Optional<Task> findById(Long aLong) {
        return taskRepository.findById(aLong);
    }

    @Override
    public Task save(Task entity) {
        return taskRepository.save(entity);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findTasksByAssignment_Id(Long assignmentId) {
        return taskRepository.findTasksByAssignment_Id(assignmentId);
    }
}
