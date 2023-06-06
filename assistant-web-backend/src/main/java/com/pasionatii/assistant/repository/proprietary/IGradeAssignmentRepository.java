package com.pasionatii.assistant.repository.proprietary;

import com.pasionatii.assistant.entity.GradeAssignment;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IGradeAssignmentRepository extends IRepository<GradeAssignment> {
    List<GradeAssignment> findGradeAssignmentsByAssignment_Id(Long AssignmentId);

}
