package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.Prof;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfRepository extends JpaRepository<Prof, Long> {
    Prof findByName(String firstName, String lastName);

    void add(String firstName, String lastName, String subject);

    void delete(String firstName, String lastName);
}
