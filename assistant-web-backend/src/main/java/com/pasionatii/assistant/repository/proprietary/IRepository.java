package com.pasionatii.assistant.repository.proprietary;

import org.springframework.stereotype.Repository;

@Repository
public interface IRepository< E> {

    void save(E entity);

    void delete(Long id);

    E findOneById(Long id);

    void update(E entity, E newEntity);

    Iterable<E> findAll();

}
