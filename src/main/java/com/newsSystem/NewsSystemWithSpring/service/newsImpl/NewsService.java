package com.newsSystem.NewsSystemWithSpring.service.newsImpl;

import com.google.common.collect.MoreCollectors;
import com.newsSystem.NewsSystemWithSpring.domain.model.News;
import com.newsSystem.NewsSystemWithSpring.domain.repository.NewsRepository;
import com.newsSystem.NewsSystemWithSpring.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService implements ServiceInterface<News> {

    private NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public News create(News obj) {
        return newsRepository.save(obj);
    }

    @Override
    public List<News> getAll() {
        return convertToDTOsNewsList(newsRepository.findAll());
    }

    @Override
    public News findObjectById(String id) {
        return newsRepository.findAll().stream().filter(news -> news.getNewsId().equals(id)).collect(MoreCollectors
                .onlyElement());
    }

    @Override
    public News update(News obj) {
        return obj;
    }

    @Override
    public void delete(News obj) {
        newsRepository.delete(obj);
    }


    //TODO Thinking about isolation
    private List<News> convertToDTOsNewsList(List<News> newsList) {
        return newsList.stream().map(this::convertToDTONews).collect(Collectors.toList());
    }

    private News convertToDTONews(News news) {
        News dtoNews = new News();
        dtoNews.setTitle(news.getTitle());
        dtoNews.setNewsId(news.getNewsId());
        dtoNews.setData(news.getData());
        dtoNews.setNewsContent(news.getNewsContent());
        dtoNews.setAuthor(news.getAuthor());

        return dtoNews;
    }
}
