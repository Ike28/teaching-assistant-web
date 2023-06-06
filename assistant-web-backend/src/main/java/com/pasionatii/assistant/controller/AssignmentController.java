package com.pasionatii.assistant.controller;

import com.pasionatii.assistant.entity.Assignment;
import com.pasionatii.assistant.entity.Task;
import com.pasionatii.assistant.repository.ITaskRepository;
import com.pasionatii.assistant.service.AssignmentService;
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
    private AssignmentService assignmentService;
    @Autowired
    private ITaskRepository taskRepository;

//    @RequestMapping(value = "?class-id={idClass}", method = RequestMethod.GET)
//    public ResponseEntity<?> getAssignmentsByClass(@PathVariable String idClass) {
//        return new ResponseEntity<>(
//                assignmentService.findAssignmentsByAssignedClass_Id(Long.parseLong(idClass)),
//                HttpStatus.OK);
//    }

    @RequestMapping(value = "?course-id={idCourse}", method = RequestMethod.GET)
    public ResponseEntity<?> getAssignmentsByCourse(@PathVariable String idCourse) {
        return new ResponseEntity<>(
                assignmentService.findAssignmentsByCourse_Id(Long.parseLong(idCourse)), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/tasks", method = RequestMethod.GET)
    public ResponseEntity<?> getTasksByAssignment(@PathVariable String id) {
        Optional<Assignment> found = assignmentService.findById(Long.parseLong(id));
        if (found.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(taskRepository.findTasksByAssignment_Id(Long.parseLong(id)), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createAssignment(@RequestBody Assignment assignment) {
        return new ResponseEntity<>(assignmentService.save(assignment), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}/tasks", method = RequestMethod.POST)
    public ResponseEntity<?> createTask(@PathVariable String id, @RequestBody Task task) {
        if (!task.getAssignment().getId().toString().equals(id)) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(taskRepository.save(task), HttpStatus.CREATED);
    }
}
