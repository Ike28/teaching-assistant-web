package com.pasionatii.assistant.controller;

import com.pasionatii.assistant.entity.Profesor;
import com.pasionatii.assistant.repository.IProfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/assistant/users/teachers")
public class ProfesorController {
    @Autowired
    private IProfRepository profRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody Profesor profesor) {
        return new ResponseEntity<>(profRepository.save(profesor), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody Profesor profesor) {
        Optional<Profesor> found = profRepository.findByEmailAndPassword(profesor.getEmail(), profesor.getPassword());
        if (found.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>(found.get(), HttpStatus.OK);
        }
    }
}
