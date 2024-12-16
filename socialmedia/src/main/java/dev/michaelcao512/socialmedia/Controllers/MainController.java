package dev.michaelcao512.socialmedia.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.michaelcao512.socialmedia.Entities.Account;
import dev.michaelcao512.socialmedia.Entities.Comment;
import dev.michaelcao512.socialmedia.Entities.Friendship;
import dev.michaelcao512.socialmedia.Entities.Post;
import dev.michaelcao512.socialmedia.Entities.UserInfo;
import dev.michaelcao512.socialmedia.Exceptions.InvalidCredentialsException;
import dev.michaelcao512.socialmedia.Services.AccountService;
import dev.michaelcao512.socialmedia.Services.CommentService;
import dev.michaelcao512.socialmedia.Services.FriendshipService;
import dev.michaelcao512.socialmedia.Services.PostService;
import dev.michaelcao512.socialmedia.Services.UserInfoService;
import dev.michaelcao512.socialmedia.dto.FriendshipRequest;
import dev.michaelcao512.socialmedia.dto.RegistrationRequest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class MainController {
    private final AccountService accountService;
    private final UserInfoService userInfoService;
    private final FriendshipService FriendshipService;
    private final PostService postService;
    private final CommentService commentService;

    public MainController(AccountService accountService, UserInfoService userInfoService,
            FriendshipService FriendshipService, PostService postService, CommentService commentService) {
        this.accountService = accountService;
        this.userInfoService = userInfoService;
        this.FriendshipService = FriendshipService;
        this.postService = postService;
        this.commentService = commentService;
    }

    /**
     * Registers an account with the given information.
     * 
     * The object in the request body should contain the first name, last name,
     * email, password, and gender of the
     * account to register.
     * 
     * @param registrationRequest The information of the account to register.
     * @return The account if the registration is successful.
     * @throws IllegalArgumentException If any of the required fields (first name,
     *                                  last name, email, password, gender) are
     *                                  null or empty.
     */
    @PostMapping("/register")
    public ResponseEntity<Account> registerAccount(@RequestBody RegistrationRequest registrationRequest) {
        try {
            Account account = accountService.registerAccount(registrationRequest);
            return ResponseEntity.ok(account);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Logs in an account with the given information.
     * 
     * The object in the request body should contain the email and password of the
     * account to log in.
     * 
     * @param loginInfo The email and password of the account to log in. *
     * @return The account if the login is successful.
     * @throws InvalidCredentialsException If the email or password is incorrect.
     * @throws IllegalArgumentException    If the account is null, or the email and
     *                                     password are null.
     */
    @GetMapping("/login")
    public ResponseEntity<Account> login(@RequestBody Account loginInfo) {
        try {
            Account account = accountService.loginAccount(loginInfo);
            return ResponseEntity.ok(account);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        } catch (InvalidCredentialsException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Updates the user information associated with the given account id.
     * 
     * The object in the request body should contain the fields to be updated.
     * If the field is not present in the request body, it will not be updated.
     * 
     * @param userInfo the user information to update
     * @return the updated user information if the update is successful
     * @throws IllegalArgumentException if the user information is not found
     */
    @PostMapping("/userinfo")
    public ResponseEntity<UserInfo> updateUserInfo(@RequestBody UserInfo userInfo) {
        try {
            UserInfo newUserInfo = userInfoService.updateUserInfo(userInfo);
            return ResponseEntity.ok(newUserInfo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Retrieves the user information associated with the given account id.
     * 
     * @param accountId the id of the account to retrieve user information for
     * @return the user information associated with the given account id
     * @throws IllegalArgumentException if the given account id does not exist
     */
    @GetMapping("/userinfo/{accountId}")
    public ResponseEntity<UserInfo> getUserInfo(@PathVariable Long accountId) {
        try {
            UserInfo userInfo = userInfoService.getUserInfo(accountId);
            return ResponseEntity.ok(userInfo);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Adds a new friendship to the database.
     * 
     * The object in the request body should contain the account and friend to be
     * added.
     * 
     * @param friendshipRequest the new friendship to be added
     * @return the added friendship
     * @throws IllegalArgumentException if account or friend is null
     * @throws IllegalArgumentException if the friendship already exists
     * @throws IllegalArgumentException if the account is the same as the friend
     */
    @PostMapping("/friendships/add")
    public ResponseEntity<Friendship> addFriend(@RequestBody FriendshipRequest friendshipRequest) {
        try {
            Friendship friendship = FriendshipService.addFriend(friendshipRequest);
            return ResponseEntity.ok(friendship);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Removes a friendship from the database.
     * 
     * @param friendshipRequest the friendship to be removed
     * @return an empty response if the friendship was successfully removed
     * @throws IllegalArgumentException if account or friend is null
     * @throws IllegalArgumentException if the friendship does not exist
     */
    @DeleteMapping("/friendships/remove")
    public ResponseEntity<Void> removeFriend(@RequestBody FriendshipRequest friendshipRequest) {
        try {
            FriendshipService.removeFriend(friendshipRequest);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Retrieves all friendships associated with the given account id.
     * 
     * @param accountId the id of the account to retrieve friendships for
     * @return a list of friendships associated with the given account id
     * @throws IllegalArgumentException if the given account id does not exist
     */
    @GetMapping("/friendships/{accountId}")
    public ResponseEntity<List<Friendship>> getFriendshipByAccountId(@PathVariable Long accountId) {
        try {
            List<Friendship> friendship = FriendshipService.getAllFriends(accountId);
            return ResponseEntity.ok(friendship);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Retrieves all posts associated with the given account id.
     * 
     * @param accountId the id of the account to retrieve posts for
     * @return a list of posts associated with the given account id
     * @throws IllegalArgumentException if the given account id does not exist
     */
    @GetMapping("/posts/{accountId}")
    public ResponseEntity<Post> getPostsByAccountId(@RequestParam Long accountId) {
        try {
            Post post = postService.getPostById(accountId);
            return ResponseEntity.ok(post);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Retrieves all posts.
     * 
     * @return a list of all posts
     */
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    /**
     * Creates a new post.
     * 
     * The object in the request body should contain the content of the post.
     * 
     * @param post the post to be created
     * @return the created post
     * @throws IllegalArgumentException if the post is null
     */
    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        try {
            Post newPost = postService.createPost(post);
            return ResponseEntity.ok(newPost);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Deletes a post with the given post id.
     * 
     * @param postId the id of the post to be deleted
     * @return an empty response if the post was successfully deleted
     * @throws IllegalArgumentException if the post does not exist
     */

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        try {
            postService.deletePost(postId);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Updates an existing post with the provided post details.
     * 
     * The object in the request body should contain the updated content of the
     * post.
     * 
     * @param post the post to be updated
     * @return the updated post if the update is successful
     * @throws IllegalArgumentException if the post is null or does not exist
     */

    @PostMapping("/posts")
    public ResponseEntity<Post> updatePost(@RequestBody Post post) {
        try {
            Post updatedPost = postService.updatePost(post);
            return ResponseEntity.ok(updatedPost);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Retrieves a post with the given post id.
     * 
     * @param postId the id of the post to be retrieved
     * @return the post with the given post id
     * @throws IllegalArgumentException if the post does not exist
     */
    @GetMapping("/posts/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable Long postId) {
        try {
            Post post = postService.getPostById(postId);
            return ResponseEntity.ok(post);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Retrieves all comments for a given post.
     * 
     * @param postId the id of the post to retrieve comments for
     * @return a list of comments associated with the given post id
     * @throws IllegalArgumentException if the post does not exist
     */

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable Long postId) {
        try {
            List<Comment> comments = commentService.getCommentsByPostId(postId);
            return ResponseEntity.ok(comments);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
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
        try {
            Comment comment = commentService.getCommentById(commentId);
            return ResponseEntity.ok(comment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
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
        try {
            Comment newComment = commentService.createComment(comment);
            return ResponseEntity.ok(newComment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
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
        try {
            Comment updatedComment = commentService.updateComment(comment);
            return ResponseEntity.ok(updatedComment);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
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
        try {
            commentService.deleteComment(commentId);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
