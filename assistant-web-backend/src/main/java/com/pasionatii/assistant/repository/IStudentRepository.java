package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Long> {
    Student findByName(String firstName, String lastName);

    void add(String firstName, String lastName, int classNr, String classType);

    void update(int classNr, String classType);

    void delete(String firstName, String lastName);
}
