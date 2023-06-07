package com.pasionatii.assistant.service;

import com.pasionatii.assistant.entity.Course;

public interface CourseService extends Service<Course, Long>{

    Course findCourseBySubject_NameAndCourseClass_Id(String name, Long classId);

    Course findCoursesByCourseClass_Id(Long classId);
}
