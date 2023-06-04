package com.pasionatii.assistant.repository.proprietary;

public interface Repository< E> {

    void save(E entity);

    void delete(Long id);

    E findOneById(Long id);

    void update(E entity, E newEntity);

    Iterable<E> findAll();

}
