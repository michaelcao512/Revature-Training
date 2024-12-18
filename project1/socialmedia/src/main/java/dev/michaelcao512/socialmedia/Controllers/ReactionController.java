package dev.michaelcao512.socialmedia.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.michaelcao512.socialmedia.Entities.Reaction;
import dev.michaelcao512.socialmedia.Services.ReactionService;

@RestController
@RequestMapping("/api/reactions")
public class ReactionController {
    private final ReactionService reactionService;

    public ReactionController(ReactionService reactionService) {
        this.reactionService = reactionService;
    }

    /**
     * Creates a new reaction for the given post and account.
     * 
     * The object in the request body should contain the post ID, account ID, and
     * type of the reaction.
     * 
     * @param reaction the reaction to be created
     * @return the created reaction if the creation is successful
     * @throws IllegalArgumentException if the reaction is null, the post does not
     *                                  exist, or the account does not exist
     */
    @PostMapping
    public ResponseEntity<Reaction> createReaction(@RequestBody Reaction reaction) {
        Reaction newReaction = reactionService.createReaction(reaction);
        return ResponseEntity.ok(newReaction);
    }

    /**
     * Retrieves a reaction with the given reaction id.
     * 
     * @param reactionId the id of the reaction to be retrieved
     * @return the reaction with the given reaction id
     * @throws IllegalArgumentException if the reaction does not exist
     */
    @GetMapping("/{reactionId}")
    public ResponseEntity<Reaction> getReactionById(@PathVariable Long reactionId) {
        Reaction reaction = reactionService.getReactionById(reactionId);
        return ResponseEntity.ok(reaction);
    }

    /**
     * Updates a reaction with the given ID.
     * 
     * @param reaction the reaction to be updated
     * @return the updated reaction if the update is successful
     * @throws IllegalArgumentException if the reaction is null or does not exist
     */
    @PatchMapping("/{reactionId}")
    public ResponseEntity<Reaction> updateReaction(@RequestBody Reaction reaction) {
        Reaction updatedReaction = reactionService.updateReaction(reaction);
        return ResponseEntity.ok(updatedReaction);
    }

    /**
     * Deletes a reaction with the given ID.
     * 
     * @param reactionId The ID of the reaction to delete
     * @return 200 OK if the reaction was deleted, 400 Bad Request if the reaction
     *         does not exist
     */
    @DeleteMapping("/{reactionId}")
    public ResponseEntity<Void> deleteReaction(@PathVariable Long reactionId) {
        reactionService.deleteReaction(reactionId);
        return ResponseEntity.ok().build();
    }

    /**
     * Retrieves all reactions for a given post.
     * 
     * @param postId the id of the post to retrieve reactions for
     * @return a list of reactions associated with the given post id
     * @throws IllegalArgumentException if the post does not exist
     */
    @GetMapping("/getReactionsByPostId/{postId}")
    public ResponseEntity<List<Reaction>> getReactionsByPostId(@PathVariable Long postId) {
        List<Reaction> reactions = reactionService.getReactionsByPostId(postId);
        return ResponseEntity.ok(reactions);
    }
}