package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByCourseClassId(Long CourseClassId);
    List<Course> findByProfessorId(Long professorId);
}
