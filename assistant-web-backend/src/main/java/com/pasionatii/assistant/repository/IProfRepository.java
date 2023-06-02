package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface IProfRepository extends JpaRepository<Profesor, Long> {
    Profesor findByName(String firstName, String lastName);
}
