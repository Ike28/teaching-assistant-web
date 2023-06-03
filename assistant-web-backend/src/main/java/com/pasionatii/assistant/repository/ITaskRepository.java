package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ITaskRepository extends JpaRepository<Task, Long> {
    List<Task> findTasksByAssignment_Id(Long assignmentId);
}
