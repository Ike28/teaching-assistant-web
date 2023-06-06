package com.pasionatii.assistant.repository.proprietary;

import com.pasionatii.assistant.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICourseRepository extends IRepository<Course> {
    List<Course> findByCourseClassId(Long classId);
    List<Course> findByProfessorId(Long professorId);


}


