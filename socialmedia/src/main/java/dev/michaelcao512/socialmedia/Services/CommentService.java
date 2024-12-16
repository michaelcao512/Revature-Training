package dev.michaelcao512.socialmedia.Services;

import org.springframework.stereotype.Service;

import dev.michaelcao512.socialmedia.Repositories.CommentRepository;

@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
}
