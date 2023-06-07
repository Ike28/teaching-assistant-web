package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGradeRepository extends JpaRepository<Grade, Long> {
    List<Grade> findAllByStudent_Id(Long studentId);
}
