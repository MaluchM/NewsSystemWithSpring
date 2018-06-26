package com.newsSystem.NewsSystemWithSpring.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document
public class Comment {

    @Id
    private String commentId;

    @NotNull(message = "News ID can't be empty")
    private String newsId;

    @NotNull(message = "Content can't be empty")
    @Size(min = 1, max = 20000, message = "min 1, max 20")
    private String commentContent;

    @NotNull(message = "Author can't be empty")
    @Size(min = 1, max = 20, message = "min 1, max 20")
    private String author;

    @NotNull(message = "Data can't be empty")
    private String data;

    public Comment() {
    }

    public Comment(String newsId, String commentContent, String author, String data) {
        this.newsId = newsId;
        this.commentContent = commentContent;
        this.author = author;
        this.data = data;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
}
