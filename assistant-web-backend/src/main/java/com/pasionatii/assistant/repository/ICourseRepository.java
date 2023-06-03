package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ICourseRepository extends JpaRepository<Course, Long> {
}
