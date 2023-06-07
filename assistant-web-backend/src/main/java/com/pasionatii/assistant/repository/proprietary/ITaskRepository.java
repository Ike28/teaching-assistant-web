package com.pasionatii.assistant.repository.proprietary;

import com.pasionatii.assistant.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ITaskRepository extends IRepository<Task>{
    List<Task> findTasksByAssignment_Id(Long assignmentId);

}
