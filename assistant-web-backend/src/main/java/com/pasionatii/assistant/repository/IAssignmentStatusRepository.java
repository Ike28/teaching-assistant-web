package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.AssignmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAssignmentStatusRepository extends JpaRepository<AssignmentStatus, Long> {
    List<AssignmentStatus> findAllByStudent_Id(Long studentId);
}
