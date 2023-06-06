package com.pasionatii.assistant.controller;

import com.pasionatii.assistant.repository.ISubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/assistant/subjects")
public class SubjectController {
    @Autowired
    private ISubjectRepository subjectRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(subjectRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "?subject-name={subjectName}", method = RequestMethod.GET)
    public ResponseEntity<?> getSubjectsByName(@PathVariable String subjectName) {
        return new ResponseEntity<>(subjectRepository.findSubjectByName(subjectName), HttpStatus.OK);
    }
}
