package com.pasionatii.assistant.service;

import com.pasionatii.assistant.entity.Subject;
import com.pasionatii.assistant.repository.ISubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class SubjectServiceImpl implements SubjectService{

    @Autowired
    private ISubjectRepository subjectRepository;

    @Override
    public Optional<Subject> findById(Long aLong) {
        return subjectRepository.findById(aLong);
    }

    @Override
    public Subject save(Subject entity) {
        return subjectRepository.save(entity);
    }

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findSubjectByName(String name) {
        return subjectRepository.findSubjectByName(name);
    }
}
