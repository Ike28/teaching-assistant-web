package com.pasionatii.assistant.controller;

import com.pasionatii.assistant.entity.Assignment;
import com.pasionatii.assistant.entity.Task;
import com.pasionatii.assistant.repository.IAssignmentRepository;
import com.pasionatii.assistant.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/assistant/assignments")
public class AssignmentController {
    @Autowired
    private IAssignmentRepository assignmentRepository;
    @Autowired
    private ITaskRepository taskRepository;

    @RequestMapping(value = "?class-id={idClass}", method = RequestMethod.GET)
    public ResponseEntity<?> getAssignmentsByClass(@PathVariable String idClass) {
        return new ResponseEntity<>(
                assignmentRepository.findAssignmentsByAssignedClass_Id(Long.parseLong(idClass)),
                HttpStatus.OK);
    }

    @RequestMapping(value = "?course-id={idCourse}", method = RequestMethod.GET)
    public ResponseEntity<?> getAssignmentsByCourse(@PathVariable String idCourse) {
        return new ResponseEntity<>(
                assignmentRepository.findAssignmentsByCourse_Id(Long.parseLong(idCourse)), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/tasks", method = RequestMethod.GET)
    public ResponseEntity<?> getTasksByAssignment(@PathVariable String id) {
        Optional<Assignment> found = assignmentRepository.findById(Long.parseLong(id));
        if (found.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(taskRepository.findTasksByAssignment_Id(Long.parseLong(id)), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createAssignment(@RequestBody Assignment assignment) {
        return new ResponseEntity<>(assignmentRepository.save(assignment), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        return new ResponseEntity<>(taskRepository.save(task), HttpStatus.CREATED);
    }
}
