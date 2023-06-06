package com.pasionatii.assistant.repository.proprietary;

import com.pasionatii.assistant.entity.Question;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IQuestionRepository extends IRepository<Question>{
    List<Question> findQuestionsByQuiz_Id(Long QuizId);

}
