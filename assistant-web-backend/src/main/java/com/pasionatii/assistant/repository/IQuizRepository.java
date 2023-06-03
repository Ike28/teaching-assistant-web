package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IQuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findQuizzesByCourse_Id(Long courseId);
}
