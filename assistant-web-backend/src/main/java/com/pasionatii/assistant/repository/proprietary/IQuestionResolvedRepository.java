package com.pasionatii.assistant.repository.proprietary;

import com.pasionatii.assistant.entity.QuestionResolved;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IQuestionResolvedRepository extends IRepository<QuestionResolved>{
    List<QuestionResolved> findQuestionResolvedByStudent_Id(Long StudentId);
    List<QuestionResolved> findQuestionResolvedByQuestion_Id(Long QuestionId);


}
