package com.wang.ssmtest.service;

import com.wang.ssmtest.bean.Comment;

import java.util.List;

public interface CommentService {
    /**
     * 保存
     * @return
     */
    boolean insert(Comment comment);

    /**
     * 查找根据条件
     * @return
     */
    List<Comment> selectByExample(Comment comment);
}
