package com.newsSystem.NewsSystemWithSpring.service;

import com.newsSystem.NewsSystemWithSpring.domain.model.Comment;

import java.util.List;

public interface CustomInterfaceForComments {

    List<Comment> getAllCommentsForNews(String id);
}
