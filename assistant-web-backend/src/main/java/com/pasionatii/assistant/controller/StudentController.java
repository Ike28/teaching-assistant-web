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
@RequestMapping("/assistant/students")
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
}
