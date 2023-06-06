package com.pasionatii.assistant.repository.proprietary;

import com.pasionatii.assistant.entity.AssignmentStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IAssignmentStatusRepository extends IRepository<AssignmentStatus>{
    List<AssignmentStatus> findAssignmentStatusByAssignment_Id(Long AssignmentId);
    List<AssignmentStatus> findAssignmentStatusByStudent_Id(Long StudentId);


}
