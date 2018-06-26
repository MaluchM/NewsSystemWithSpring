package com.newsSystem.NewsSystemWithSpring;

import com.newsSystem.NewsSystemWithSpring.domain.model.Comment;
import com.newsSystem.NewsSystemWithSpring.domain.model.News;
import com.newsSystem.NewsSystemWithSpring.service.commentsImpl.CommentsService;
import com.newsSystem.NewsSystemWithSpring.service.newsImpl.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan
public class NewsSystemWithSpringApplication implements CommandLineRunner {

	@Autowired
	public NewsService newsService;

	@Autowired
	public CommentsService commentsService;


	public static void main(String[] args) {
		SpringApplication.run(NewsSystemWithSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		newsService.create(new News("To jest tytuł", "To jest treść", "21.06.2018", ""));
		commentsService.create(new Comment("4234235", "Treść komentarza", "Jestem Autorem", "21.06.2018"));
	}
}
