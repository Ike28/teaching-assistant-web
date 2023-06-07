package com.pasionatii.assistant.service;

import com.pasionatii.assistant.entity.Profesor;
import com.pasionatii.assistant.repository.IProfRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProfServiceImpl implements ProfService{

    @Autowired
    private IProfRepository profRepository;

    @Override
    public Optional<Profesor> findByEmailAndPassword(String email, String password) {
        return profRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public Optional<Profesor> findById(Long aLong) {
        return profRepository.findById(aLong);
    }

    @Override
    public Profesor save(Profesor entity) {
        return profRepository.save(entity);
    }

    @Override
    public List<Profesor> findAll() {
        return profRepository.findAll();
    }
}
