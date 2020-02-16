package com.wang.ssmtest.bean;


public class Comment {
    private Integer id;
    private String content;
    private Integer userOwnId;
    private Integer articleId;
    private String date;
    private Integer commentId;
    private Integer commentIdId;
    private Integer UserOtherId;

    private User userOwn;
    private User UserOther;

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

    public Integer getUserOwnId() {
        return userOwnId;
    }

    public void setUserOwnId(Integer userOwnId) {
        this.userOwnId = userOwnId;
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

    public Integer getCommentIdId() {
        return commentIdId;
    }

    public void setCommentIdId(Integer commentIdId) {
        this.commentIdId = commentIdId;
    }

    public Integer getUserOtherId() {
        return UserOtherId;
    }

    public void setUserOtherId(Integer userOtherId) {
        UserOtherId = userOtherId;
    }

    public User getUserOwn() {
        return userOwn;
    }

    public void setUserOwn(User userOwn) {
        this.userOwn = userOwn;
    }

    public User getUserOther() {
        return UserOther;
    }

    public void setUserOther(User userOther) {
        UserOther = userOther;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", userOwnId=" + userOwnId +
                ", articleId=" + articleId +
                ", date='" + date + '\'' +
                ", commentId=" + commentId +
                ", commentIdId=" + commentIdId +
                ", UserOtherId=" + UserOtherId +
                ", userOwn=" + userOwn +
                ", UserOther=" + UserOther +
                '}';
    }
}
