package com.pasionatii.assistant.controller;

import com.pasionatii.assistant.entity.Quiz;
import com.pasionatii.assistant.repository.IQuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/assistant/quizzes")
public class QuizController {
    @Autowired
    private IQuizRepository quizRepository;

    @RequestMapping(value = "?course-id={courseId}", method = RequestMethod.GET)
    public ResponseEntity<?> getQuizzesByCourse(@PathVariable String courseId) {
        return new ResponseEntity<>(quizRepository.findQuizzesByCourse_Id(Long.parseLong(courseId)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Quiz quiz) {
        return new ResponseEntity<>(quizRepository.save(quiz), HttpStatus.CREATED);
    }
}
