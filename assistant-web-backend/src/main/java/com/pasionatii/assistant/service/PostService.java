package com.pasionatii.assistant.service;

import com.pasionatii.assistant.entity.Post;

import java.util.List;

public interface PostService extends Service<Post, Long>{

    List<Post> findPostsByCourse_Id(Long courseId);
}
