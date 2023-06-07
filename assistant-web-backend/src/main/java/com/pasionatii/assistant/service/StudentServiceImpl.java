package com.pasionatii.assistant.service;

import com.pasionatii.assistant.entity.Student;
import com.pasionatii.assistant.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService{

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public Optional<Student> findById(Long aLong) {
        return studentRepository.findById(aLong);
    }

    @Override
    public Student save(Student entity) {
        return studentRepository.save(entity);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findStudentsByAssignedClass_Id(Long classId) {
        return studentRepository.findStudentsByAssignedClass_Id(classId);
    }

    @Override
    public Optional<Student> findByEmailAndPassword(String email, String password) {
        return studentRepository.findByEmailAndPassword(email, password);
    }
}
