package com.pasionatii.assistant.repository.proprietary;

import com.pasionatii.assistant.entity.Quiz;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IQuizRepository extends IRepository<Quiz>{
    List<Quiz> findQuizzesByCourse_Id(Long courseId);

}
