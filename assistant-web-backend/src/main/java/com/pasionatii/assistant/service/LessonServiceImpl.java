package com.pasionatii.assistant.service;

import com.pasionatii.assistant.entity.Lesson;
import com.pasionatii.assistant.repository.ILessonRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class LessonServiceImpl implements LessonService{

    @Autowired
    private ILessonRepository lessonRepository;

    @Override
    public List<Lesson> findLessonsByCourse_Id(Long courseId) {
        return lessonRepository.findLessonsByCourse_Id(courseId);
    }

    @Override
    public Optional<Lesson> findById(Long aLong) {
        return lessonRepository.findById(aLong);
    }

    @Override
    public Lesson save(Lesson entity) {
        return lessonRepository.save(entity);
    }

    @Override
    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }
}
