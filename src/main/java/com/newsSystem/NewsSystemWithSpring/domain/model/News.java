package com.newsSystem.NewsSystemWithSpring.domain.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Document
public class News {

    @Id
    private String newsId;

    @NotNull(message = "Title can't be null")
    @Size(min = 5, max = 40, message = "min 5, max 40")
    private String title;

    @NotNull
    @Size(min = 2, message = "min 2")
    private String newsContent;
    private String data;

    @NotNull
    @Size(min = 1, message = "min 1")
    private String author;

    public News() {
    }

    public News(String title, String newsContent, String data, String author) {
        this.title = title;
        this.newsContent = newsContent;
        this.data = data;
        this.author = author;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
