package com.pasionatii.assistant.service;

import com.pasionatii.assistant.entity.Course;
import com.pasionatii.assistant.repository.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class CourseServiceImpl implements CourseService{

    @Autowired
    private ICourseRepository courseRepository;

    @Override
    public Course findCourseBySubject_NameAndCourseClass_Id(String name, Long classId) {
        return courseRepository.findCourseBySubject_NameAndCourseClass_Id(name, classId);
    }

    @Override
    public Course findCoursesByCourseClass_Id(Long classId) {
        return courseRepository.findCoursesByCourseClass_Id(classId);
    }

    @Override
    public Optional<Course> findById(Long aLong) {
        return courseRepository.findById(aLong);
    }

    @Override
    public Course save(Course entity) {
        return courseRepository.save(entity);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
