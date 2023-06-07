package com.pasionatii.assistant.service;

import com.pasionatii.assistant.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService extends Service<Student, Long>{

    List<Student> findStudentsByAssignedClass_Id(Long classId);

    Optional<Student> findByEmailAndPassword(String email, String password);
}
