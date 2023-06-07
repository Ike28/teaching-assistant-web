package com.pasionatii.assistant.service;

import com.pasionatii.assistant.entity.Lesson;

import java.util.List;

public interface LessonService extends Service<Lesson, Long>{

    List<Lesson> findLessonsByCourse_Id(Long courseId);
}
