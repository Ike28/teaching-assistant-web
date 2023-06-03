package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.Class;
import com.pasionatii.assistant.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IStudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentsByAssignedClass_Id(Long classId);
}
