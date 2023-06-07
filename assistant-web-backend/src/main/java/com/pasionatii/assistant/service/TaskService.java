package com.pasionatii.assistant.service;

import com.pasionatii.assistant.entity.Task;

import java.util.List;

public interface TaskService extends Service<Task, Long>{

    List<Task> findTasksByAssignment_Id(Long assignmentId);
}
