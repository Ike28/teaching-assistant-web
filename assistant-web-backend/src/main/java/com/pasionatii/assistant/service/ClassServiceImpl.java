package com.pasionatii.assistant.service;

import com.pasionatii.assistant.entity.Class;
import com.pasionatii.assistant.repository.IClassRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ClassServiceImpl implements ClassService{

    @Autowired
    private IClassRepository classRepository;

    @Override
    public Optional<Class> findById(Long aLong) {
        return classRepository.findById(aLong);
    }

    @Override
    public Class save(Class entity) {
        return classRepository.save(entity);
    }

    @Override
    public List<Class> findAll() {
        return classRepository.findAll();
    }
}
