package dev.michaelcao512.socialmedia.Controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.michaelcao512.socialmedia.Entities.Comment;
import dev.michaelcao512.socialmedia.Services.CommentService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * Retrieves a comment with the given comment id.
     * 
     * @param commentId the id of the comment to be retrieved
     * @return the comment with the given comment id
     * @throws IllegalArgumentException if the comment does not exist
     */
    @GetMapping("/comments/{commentId}")
    public ResponseEntity<Comment> getCommentById(@PathVariable Long commentId) {
        Comment comment = commentService.getCommentById(commentId);
        return ResponseEntity.ok(comment);
    }

    /**
     * Creates a new comment for the given post and account.
     * 
     * The object in the request body should contain the post ID, account ID, and
     * content of the comment.
     * 
     * @param comment the comment to be created
     * @return the created comment if the creation is successful
     * @throws IllegalArgumentException if the comment is null, the post does not
     *                                  exist, or the account does not exist
     */
    @PostMapping("/comments/create")
    public ResponseEntity<Comment> createComment(@RequestBody Comment comment) {
        Comment newComment = commentService.createComment(comment);
        return ResponseEntity.ok(newComment);
    }

    /**
     * Updates a comment with the given ID.
     * 
     * @param comment the comment to be updated
     * @return the updated comment if the update is successful
     * @throws IllegalArgumentException if the comment is null or does not exist
     */
    @PostMapping("/comments/update")
    public ResponseEntity<Comment> updateComment(@RequestBody Comment comment) {
        Comment updatedComment = commentService.updateComment(comment);
        return ResponseEntity.ok(updatedComment);

    }

    /**
     * Deletes a comment with the given ID.
     * 
     * @param commentId The ID of the comment to delete
     * @return 200 OK if the comment was deleted, 400 Bad Request if the comment
     *         does not exist
     */
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
        return ResponseEntity.ok().build();
    }

    /**
     * Retrieves all comments for a given post.
     * 
     * @param postId the id of the post to retrieve comments for
     * @return a list of comments associated with the given post id
     * @throws IllegalArgumentException if the post does not exist
     */

    @GetMapping("/{postId}/comments")
    public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable Long postId) {
        List<Comment> comments = commentService.getCommentsByPostId(postId);
        return ResponseEntity.ok(comments);
    }
}