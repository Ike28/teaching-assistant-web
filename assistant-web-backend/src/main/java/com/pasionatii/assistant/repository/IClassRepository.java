package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassRepository extends JpaRepository<Class, Long> {
}
