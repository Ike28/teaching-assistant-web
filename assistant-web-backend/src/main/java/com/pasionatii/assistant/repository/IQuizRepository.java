package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IQuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findQuizzesByCourse_Id(Long courseId);
}
