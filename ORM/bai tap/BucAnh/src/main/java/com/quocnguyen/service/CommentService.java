package com.quocnguyen.service;

import com.quocnguyen.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> listAll();
    void createComment(Comment comment);
}
