package com.wang.ssmtest.service.impl;

import com.wang.ssmtest.bean.Comment;
import com.wang.ssmtest.dao.CommentMapper;
import com.wang.ssmtest.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Override
    public boolean insert(Comment comment) {
        return commentMapper.insert(comment)==1;
    }

    @Override
    public List<Comment> selectByExample(Comment comment) {
        return null;
    }
}
