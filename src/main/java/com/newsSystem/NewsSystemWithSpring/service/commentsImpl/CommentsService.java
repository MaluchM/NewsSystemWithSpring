package com.newsSystem.NewsSystemWithSpring.service.commentsImpl;

import com.google.common.collect.MoreCollectors;
import com.newsSystem.NewsSystemWithSpring.domain.model.Comment;
import com.newsSystem.NewsSystemWithSpring.domain.repository.CommentRepository;
import com.newsSystem.NewsSystemWithSpring.service.CustomInterfaceForComments;
import com.newsSystem.NewsSystemWithSpring.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentsService implements ServiceInterface<Comment>, CustomInterfaceForComments {

    private CommentRepository commentRepository;

    @Autowired
    public CommentsService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment create(Comment obj) {
        return commentRepository.save(obj);
    }

    @Override
    public List<Comment> getAll() {
        return convertToDTOsCommentsList(commentRepository.findAll());
    }

    //TODO Thinking about Optional
    @Override
    public Comment findObjectById(String id) {
        return commentRepository.findAll().stream().filter(comment -> comment.getCommentId().equals(id)).collect
                (MoreCollectors.onlyElement());
    }

    @Override
    public Comment update(Comment obj) {
        return null;
    }

    @Override
    public void delete(Comment obj) {
        commentRepository.delete(obj);
    }


    //TODO Thinking about isolation
    private List<Comment> convertToDTOsCommentsList(List<Comment> commentsList) {
        return commentsList.stream().map(this::convertToDTOComment).collect(Collectors.toList());
    }

    private Comment convertToDTOComment(Comment comment) {

        Comment dtoComment = new Comment();

        dtoComment.setAuthor(comment.getAuthor());
        dtoComment.setCommentContent(comment.getCommentContent());
        dtoComment.setCommentId(comment.getCommentId());
        dtoComment.setData(comment.getData());
        dtoComment.setNewsId(comment.getNewsId());

        return dtoComment;
    }

    @Override
    public List<Comment> getAllCommentsForNews(String id) {
        List<Comment> commentList = commentRepository.findAll().stream().filter(comment -> comment.getNewsId().equals(id)).collect
                (Collectors.toList());
        return convertToDTOsCommentsList(commentList);
    }
}
