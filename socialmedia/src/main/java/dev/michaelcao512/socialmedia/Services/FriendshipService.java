package dev.michaelcao512.socialmedia.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.michaelcao512.socialmedia.Repositories.FriendshipRepository;

@Service
public class FriendshipService {
    private final FriendshipRepository friendshipRepository;
    public FriendshipService(FriendshipRepository friendshipRepository) {
        this.friendshipRepository = friendshipRepository;
    }
}
