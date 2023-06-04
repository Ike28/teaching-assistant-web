package com.pasionatii.assistant.controller;

import com.pasionatii.assistant.entity.*;
import com.pasionatii.assistant.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/assistant/users/students")
public class StudentController {
    @Autowired
    private IStudentRepository studentRepository;

    @RequestMapping(value = "?class-id={idClass}", method = RequestMethod.GET)
    public ResponseEntity<?> getAllByClass(@PathVariable String idClass) {
        return new ResponseEntity<>(studentRepository.findStudentsByAssignedClass_Id(Long.parseLong(idClass)), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/assignments", method = RequestMethod.GET)
    public ResponseEntity<?> getAssignmentsForStudent(@PathVariable String id) {
        Optional<Student> student = studentRepository.findById(Long.parseLong(id));
        if (student.isEmpty()) {
            return new ResponseEntity<>("Student not found!", HttpStatus.NOT_FOUND);
        } else {
            Student found = student.get();
            return new ResponseEntity<>(found.getAssignmentStatuses(), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}/grades", method = RequestMethod.GET)
    public ResponseEntity<?> getAssignmentGradesForStudent(@PathVariable String id) {
        Optional<Student> student = studentRepository.findById(Long.parseLong(id));
        if (student.isEmpty()) {
            return new ResponseEntity<>("Student not found!", HttpStatus.NOT_FOUND);
        } else {
            Student found = student.get();
            return new ResponseEntity<>(found.getGrades(), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Student student) {
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody Student student) {
        Optional<Student> found = studentRepository.findByEmailAndPassword(student.getEmail(), student.getPassword());
        if (found.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>(found.get(), HttpStatus.OK);
        }
    }
}
