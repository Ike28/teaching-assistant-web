package com.pasionatii.assistant.repository.proprietary;

import com.pasionatii.assistant.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IPostRepository extends IRepository<Post>{
    List<Post> findPostsByCourse_Id(Long courseId);

}
