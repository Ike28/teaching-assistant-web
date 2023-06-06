package com.pasionatii.assistant.repository.proprietary;

import com.pasionatii.assistant.entity.CommentPost;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICommentPostRepository  extends IRepository<CommentPost>{
    List<CommentPost> findCommentPostsByPost_Id(Long postId);
}
