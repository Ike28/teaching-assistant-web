package com.pasionatii.assistant.service;

import com.pasionatii.assistant.entity.Post;
import com.pasionatii.assistant.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class PostServiceImpl implements PostService{

    @Autowired
    private IPostRepository postRepository;

    @Override
    public List<Post> findPostsByCourse_Id(Long courseId) {
        return postRepository.findPostsByCourse_Id(courseId);
    }

    @Override
    public Optional<Post> findById(Long aLong) {
        return postRepository.findById(aLong);
    }

    @Override
    public Post save(Post entity) {
        return postRepository.save(entity);
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
