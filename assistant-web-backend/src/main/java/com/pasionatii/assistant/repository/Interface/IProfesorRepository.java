package com.pasionatii.assistant.repository.Interface;

import com.pasionatii.assistant.entity.Profesor;

public interface IProfesorRepository extends Repository<Profesor> {
    Iterable<Profesor> findOneByUsernameAndPassword(String username,String password);

}
