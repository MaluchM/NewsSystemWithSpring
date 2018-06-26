package com.newsSystem.NewsSystemWithSpring.domain.repository;

import com.newsSystem.NewsSystemWithSpring.domain.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {

}
