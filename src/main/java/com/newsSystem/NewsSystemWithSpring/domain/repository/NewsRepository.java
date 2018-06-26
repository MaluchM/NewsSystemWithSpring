package com.newsSystem.NewsSystemWithSpring.domain.repository;


import com.newsSystem.NewsSystemWithSpring.domain.model.News;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends MongoRepository<News, String> {

}
