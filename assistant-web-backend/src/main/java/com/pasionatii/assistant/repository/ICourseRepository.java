package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {
    Course findCourseBySubject_NameAndCourseClass_Id(String name, Long classId);

    List<Course> findCoursesByCourseClass_Id(Long classId);
}
