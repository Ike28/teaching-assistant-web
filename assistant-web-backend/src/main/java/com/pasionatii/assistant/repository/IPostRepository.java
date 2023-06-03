package com.pasionatii.assistant.repository;

import com.pasionatii.assistant.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IPostRepository extends JpaRepository<Post, Long> {
    List<Post> findPostsByCourse_Id(Long courseId);
}
