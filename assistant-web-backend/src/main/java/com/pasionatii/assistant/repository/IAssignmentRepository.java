package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IAssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findAssignmentsByAssignedClass_Id(Long classId);

    List<Assignment> findAssignmentsByCourse_Id(Long courseId);
}
