package com.pasionatii.assistant.service;

import com.pasionatii.assistant.entity.Quiz;
import com.pasionatii.assistant.repository.IQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class QuizServiceImpl implements QuizService{

    @Autowired
    private IQuizRepository quizRepository;

    @Override
    public List<Quiz> findQuizzesByCourse_Id(Long courseId) {
        return quizRepository.findQuizzesByCourse_Id(courseId);
    }

    @Override
    public Optional<Quiz> findById(Long aLong) {
        return quizRepository.findById(aLong);
    }

    @Override
    public Quiz save(Quiz entity) {
        return quizRepository.save(entity);
    }

    @Override
    public List<Quiz> findAll() {
        return quizRepository.findAll();
    }
}
