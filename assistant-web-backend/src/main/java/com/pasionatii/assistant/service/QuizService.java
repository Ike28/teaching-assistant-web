package com.pasionatii.assistant.service;

import com.pasionatii.assistant.entity.Quiz;

import java.util.List;

public interface QuizService extends Service<Quiz, Long>{

    List<Quiz> findQuizzesByCourse_Id(Long courseId);
}
