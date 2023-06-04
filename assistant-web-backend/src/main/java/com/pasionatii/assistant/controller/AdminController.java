package com.pasionatii.assistant.controller;

import com.pasionatii.assistant.entity.Admin;
import com.pasionatii.assistant.entity.Student;
import com.pasionatii.assistant.repository.IAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/assistant/admins")
public class AdminController {
    @Autowired
    private IAdminRepository adminRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody Student student) {
        Optional<Admin> found = adminRepository.findByEmailAndPassword(student.getEmail(), student.getPassword());
        if (found.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } else {
            return new ResponseEntity<>(found.get(), HttpStatus.OK);
        }
    }
}
