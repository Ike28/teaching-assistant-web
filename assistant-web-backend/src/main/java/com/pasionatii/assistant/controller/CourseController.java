package com.pasionatii.assistant.controller;

import com.pasionatii.assistant.entity.Course;
import com.pasionatii.assistant.entity.Post;
import com.pasionatii.assistant.repository.ICourseRepository;
import com.pasionatii.assistant.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/assistant/courses")
public class CourseController {
    @Autowired
    private ICourseRepository courseRepository;
    @Autowired
    private IPostRepository postRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
    public ResponseEntity<?> getPostsByCourse(@PathVariable String id) {
        return new ResponseEntity<>(postRepository.findPostsByCourse_Id(Long.parseLong(id)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseRepository.save(course), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public ResponseEntity<?> createPost(@RequestBody Post post) {
        return new ResponseEntity<>(postRepository.save(post), HttpStatus.CREATED);
    }
}
