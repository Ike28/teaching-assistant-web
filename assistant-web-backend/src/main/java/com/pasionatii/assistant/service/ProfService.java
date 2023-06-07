package com.pasionatii.assistant.service;

import com.pasionatii.assistant.entity.Profesor;

import java.util.Optional;

public interface ProfService extends Service<Profesor, Long>{

    Optional<Profesor> findByEmailAndPassword(String email, String password);
}
