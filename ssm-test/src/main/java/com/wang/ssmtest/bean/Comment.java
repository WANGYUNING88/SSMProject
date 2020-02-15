package com.wang.ssmtest.bean;

import java.util.Date;

public class Comment {
    private Integer id;
    private String content;
    private Integer userId;
    private Integer articleId;
    private String date;
    private Integer commentId;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", articleId=" + articleId +
                ", date='" + date + '\'' +
                ", commentId=" + commentId +
                ", user=" + user +
                '}';
    }

    public Comment(Integer id, String content, Integer userId, Integer articleId, String date, Integer commentId) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.articleId = articleId;
        this.date = date;
        this.commentId = commentId;
    }

    public Comment() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
}
