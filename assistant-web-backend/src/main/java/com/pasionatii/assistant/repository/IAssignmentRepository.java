package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAssignmentRepository extends JpaRepository<Assignment, Long> {
    List<Assignment> findAssignmentsByCourse_Id(Long courseId);
}
