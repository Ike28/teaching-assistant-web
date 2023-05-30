package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfRepository extends JpaRepository<Profesor, Long> {
    Profesor findByName(String firstName, String lastName);

    void add(String firstName, String lastName, String subject);

    void delete(String firstName, String lastName);
}
