package com.pasionatii.assistant.controller;

import com.pasionatii.assistant.entity.Class;
import com.pasionatii.assistant.repository.IClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/assistant/classes")
public class ClassController {
    @Autowired
    private IClassRepository classRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(classRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable String id) {
        Optional<Class> found = classRepository.findById(Long.parseLong(id));
        if (found.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(found.get(), HttpStatus.OK);
        }
    }
}
