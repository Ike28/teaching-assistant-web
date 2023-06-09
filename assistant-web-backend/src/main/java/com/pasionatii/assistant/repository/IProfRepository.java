package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProfRepository extends JpaRepository<Profesor, Long> {
    Optional<Profesor> findByEmailAndPassword(String email, String password);
}
