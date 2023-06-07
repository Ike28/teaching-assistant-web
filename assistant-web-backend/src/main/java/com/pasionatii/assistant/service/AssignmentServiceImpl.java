package com.pasionatii.assistant.service;

import com.pasionatii.assistant.entity.Assignment;
import com.pasionatii.assistant.repository.IAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentServiceImpl implements AssignmentService {
    @Autowired
    private IAssignmentRepository assignmentRepository;

//    @Override
//    public List<Assignment> findAssignmentsByAssignedClass_Id(Long classId) {
//        return assignmentRepository.findAssignmentsByAssignedClass_Id(classId);
//    }

    @Override
    public List<Assignment> findAssignmentsByCourse_Id(Long courseId) {
        return assignmentRepository.findAssignmentsByCourse_Id(courseId);
    }

    @Override
    public Optional<Assignment> findById(Long aLong) {
        return assignmentRepository.findById(aLong);
    }

    @Override
    public Assignment save(Assignment entity) {
        return assignmentRepository.save(entity);
    }

    @Override
    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }
}
