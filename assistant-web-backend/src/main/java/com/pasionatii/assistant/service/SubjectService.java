package com.pasionatii.assistant.service;

import com.pasionatii.assistant.entity.Subject;

public interface SubjectService extends Service<Subject, Long>{

    Subject findSubjectByName(String name);
}
