package com.pasionatii.assistant.controller;

import com.pasionatii.assistant.entity.*;
import com.pasionatii.assistant.entity.Class;
import com.pasionatii.assistant.repository.IClassRepository;
import com.pasionatii.assistant.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/assistant/classes/{idClass}/students")
public class StudentController {
    @Autowired
    private IClassRepository classRepository;
    @Autowired
    private IStudentRepository studentRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAllByClass(@PathVariable String idClass) {
        Optional<Class> foundClass = classRepository.findById(Long.parseLong(idClass));
        if (foundClass.isEmpty()) {
            return new ResponseEntity<>("Class not found!", HttpStatus.NOT_FOUND);
        } else {
            Class assignedClass = foundClass.get();
            return new ResponseEntity<>(studentRepository.findStudentsByAssignedClass(assignedClass), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/{id}/assignments", method = RequestMethod.GET)
    public ResponseEntity<?> getAssignmentsForStudent(@PathVariable String idClass, @PathVariable String id) {
        Optional<Class> foundClass = classRepository.findById(Long.parseLong(idClass));
        if (foundClass.isEmpty()) {
            return new ResponseEntity<>("Class not found!", HttpStatus.NOT_FOUND);
        } else {
            Optional<Student> student = studentRepository.findById(Long.parseLong(id));
            if (student.isEmpty()) {
                return new ResponseEntity<>("Student not found!", HttpStatus.NOT_FOUND);
            } else {
                Student found = student.get();
                return new ResponseEntity<>(found.getAssignmentStatuses(), HttpStatus.OK);
            }
        }
    }

    @RequestMapping(value = "/{id}/grades", method = RequestMethod.GET)
    public ResponseEntity<?> getAssignmentGradesForStudent(@PathVariable String idClass, @PathVariable String id) {
        Optional<Class> foundClass = classRepository.findById(Long.parseLong(idClass));
        if (foundClass.isEmpty()) {
            return new ResponseEntity<>("Class not found!", HttpStatus.NOT_FOUND);
        } else {
            Optional<Student> student = studentRepository.findById(Long.parseLong(id));
            if (student.isEmpty()) {
                return new ResponseEntity<>("Student not found!", HttpStatus.NOT_FOUND);
            } else {
                Student found = student.get();
                return new ResponseEntity<>(found.getGrades(), HttpStatus.OK);
            }
        }
    }
}
