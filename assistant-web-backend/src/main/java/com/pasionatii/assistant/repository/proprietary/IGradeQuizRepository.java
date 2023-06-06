package com.pasionatii.assistant.repository.proprietary;

import com.pasionatii.assistant.entity.GradeQuiz;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IGradeQuizRepository extends IRepository<GradeQuiz>{
    List<GradeQuiz> findGradeQuizsByQuiz_Id(Long QuizId);

}
