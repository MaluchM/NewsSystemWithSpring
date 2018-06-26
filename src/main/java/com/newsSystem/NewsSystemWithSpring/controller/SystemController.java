package com.newsSystem.NewsSystemWithSpring.controller;

import com.newsSystem.NewsSystemWithSpring.domain.model.Comment;
import com.newsSystem.NewsSystemWithSpring.domain.model.News;
import com.newsSystem.NewsSystemWithSpring.service.commentsImpl.CommentsService;
import com.newsSystem.NewsSystemWithSpring.service.newsImpl.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api")

public class SystemController {

    private final NewsService newsService;
    private final CommentsService commentsService;
    private final Map<String, Object> response = new LinkedHashMap<>();

    @Autowired
    public SystemController(NewsService newsService, CommentsService commentsService) {
        this.newsService = newsService;
        this.commentsService = commentsService;
    }

    @GetMapping("/getNews")
    public List<News> findAllNews() {
        return newsService.getAll();
    }

    @GetMapping("/getComment")
    public List<Comment> findAllComments() {
        return commentsService.getAll();
    }

    @PostMapping("/saveNews")
    public Map<String, Object> saveNews(@Valid @RequestBody News newNews, BindingResult bindingResult) {

        if (checkErrors(bindingResult)) {
            newsService.create(newNews);
            response.put("message", "News created successufully");
        }
        return response;
    }

    @PostMapping("/saveComment")
    public Map<String, Object> saveComment(@Valid @RequestBody Comment comment, BindingResult bindingResult) {

        if(checkErrors(bindingResult)) {
            commentsService.create(comment);
            response.put("message", "Coment created successufully");
        }
        return response;
    }

    //TODO Optional? Stream?
    private boolean checkErrors(BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            response.put("message", "Error");
            for (FieldError error : errors) {
                response.put(error.getField(), error.getDefaultMessage());
            }
            return false;
        } else {
            return true;
        }
    }
}
