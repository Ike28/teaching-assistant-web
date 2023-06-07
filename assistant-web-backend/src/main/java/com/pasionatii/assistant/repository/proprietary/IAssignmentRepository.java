package com.pasionatii.assistant.repository.proprietary;

import com.pasionatii.assistant.entity.Assignment;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IAssignmentRepository extends IRepository<Assignment> {
   // List<Assignment> findAssignmentsByAssignedClass_Id(Long classId);

    List<Assignment> findAssignmentsByCourse_Id(Long courseId);
}
