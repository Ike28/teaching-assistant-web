package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface IStudentRepository extends JpaRepository<Student, Long> {
    Student findByName(String firstName, String lastName);
}
