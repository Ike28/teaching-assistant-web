package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ISubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findAll();

    Subject findSubjectByName(String name);
}
