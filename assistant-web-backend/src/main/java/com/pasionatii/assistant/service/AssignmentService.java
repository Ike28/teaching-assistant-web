package com.pasionatii.assistant.service;

import com.pasionatii.assistant.entity.Assignment;

import java.util.List;

public interface AssignmentService extends Service<Assignment, Long> {
   // List<Assignment> findAssignmentsByAssignedClass_Id(Long classId);

    List<Assignment> findAssignmentsByCourse_Id(Long courseId);
}
