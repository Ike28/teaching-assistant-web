package com.pasionatii.assistant.repository.proprietary;

import com.pasionatii.assistant.entity.Grade;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IGradeRepository  extends IRepository<Grade>{
    List<Grade> findGradesByStudent_Id(Long StudentId);

}
