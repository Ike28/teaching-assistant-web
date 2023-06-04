package com.pasionatii.assistant.service;

import java.util.List;
import java.util.Optional;

public interface Service<T, ID> {
    Optional<T> findById(ID id);

    T save(T entity);

    List<T> findAll();
}
