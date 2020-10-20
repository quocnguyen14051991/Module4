package com.quocnguyen.service.impl;

import com.quocnguyen.entity.Comment;
import com.quocnguyen.repository.CommentRepository;
import com.quocnguyen.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> listAll() {
        return commentRepository.listAll();
    }

    @Override
    public void createComment(Comment comment) {
        commentRepository.createComment(comment);
    }
}
