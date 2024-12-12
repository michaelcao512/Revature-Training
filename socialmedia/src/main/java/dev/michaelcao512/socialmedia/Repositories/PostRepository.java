package dev.michaelcao512.socialmedia.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.michaelcao512.socialmedia.Entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    
}
