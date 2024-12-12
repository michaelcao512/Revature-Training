package dev.michaelcao512.socialmedia.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.michaelcao512.socialmedia.Entities.Friendship;

@Repository
public interface FriendshipRepository extends JpaRepository<Friendship, Long> {
    
}
