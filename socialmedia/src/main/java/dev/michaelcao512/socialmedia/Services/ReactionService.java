package dev.michaelcao512.socialmedia.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.michaelcao512.socialmedia.Repositories.ReactionRepository;

@Service
public class ReactionService {
    private final ReactionRepository reactionRepository;
    public ReactionService(ReactionRepository reactionRepository) {
        this.reactionRepository = reactionRepository;
    }
}
