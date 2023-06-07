package com.pasionatii.assistant.repository.proprietary;

import com.pasionatii.assistant.entity.Profesor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IProfesorRepository extends IRepository<Profesor>{
    Optional<Profesor> findByEmailAndPassword(String email, String password);

}
