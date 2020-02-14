package com.wang.ssmtest.dao;

import com.wang.ssmtest.bean.Comment;

import java.util.List;

public interface CommentMapper {
    /**
     * 保存
     * @return
     */
    int insert(Comment comment);

    /**
     * 查找根据条件
     * @return
     */
    List<Comment> selectByExample(Comment comment);

}
