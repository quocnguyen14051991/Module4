package com.quocnguyen.repository;

import com.quocnguyen.entity.Comment;

import java.util.List;

public interface CommentRepository {
    List<Comment> listAll();
    void createComment(Comment comment);
}
