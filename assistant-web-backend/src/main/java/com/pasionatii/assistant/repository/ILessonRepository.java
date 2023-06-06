package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.Lesson;
import com.pasionatii.assistant.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findLessonsByCourse_Id(Long courseId);
}
