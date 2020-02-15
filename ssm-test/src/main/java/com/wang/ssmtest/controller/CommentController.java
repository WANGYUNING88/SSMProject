package com.wang.ssmtest.controller;

import com.wang.ssmtest.bean.Comment;
import com.wang.ssmtest.bean.Msg;
import com.wang.ssmtest.service.CommentService;
import com.wang.ssmtest.utils.ConstUtils;
import com.wang.ssmtest.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.Date;

@Controller
@RequestMapping("comment")
public class CommentController {
    @Autowired
    CommentService commentService;
    @ResponseBody
    @RequestMapping("saveComment")
    public Msg insertComment(Comment comment) throws ParseException {
        comment.setDate(DateUtil.getStringByDate(new Date(), ConstUtils.FORMAT));
        boolean insert = commentService.insert(comment);
        if (insert){
            return Msg.success().add("comment",comment);
        }else {
            return Msg.fail();
        }
    }
}
