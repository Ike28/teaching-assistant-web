package com.pasionatii.assistant.repository.proprietary;

import com.pasionatii.assistant.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface IStudentRepository extends IRepository<Student> {
    List<Student> findStudentsByAssignedClass_Id(Long classId);

    Optional<Student> findByEmailAndPassword(String email, String password);
}
