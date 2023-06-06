package com.pasionatii.assistant.repository.proprietary;

import com.pasionatii.assistant.entity.TaskStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ITaskStatusRepository extends IRepository<TaskStatus>{
    List<TaskStatus> findTaskStatusByTask_Id(Long TaskId);
    List<TaskStatus> findTaskStatusByStudent_Id(Long StudentId);

}
