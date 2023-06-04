package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentsByAssignedClass_Id(Long classId);
}
