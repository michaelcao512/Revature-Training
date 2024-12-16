package dev.michaelcao512.socialmedia.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.michaelcao512.socialmedia.Entities.Account;
import dev.michaelcao512.socialmedia.Entities.Friendship;
import dev.michaelcao512.socialmedia.Entities.UserInfo;
import dev.michaelcao512.socialmedia.Exceptions.InvalidCredentialsException;
import dev.michaelcao512.socialmedia.Services.AccountService;
import dev.michaelcao512.socialmedia.Services.FriendshipService;
import dev.michaelcao512.socialmedia.Services.UserInfoService;
import dev.michaelcao512.socialmedia.dto.FriendshipRequest;
import dev.michaelcao512.socialmedia.dto.RegistrationRequest;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;
    private final UserInfoService userInfoService;
    private final FriendshipService FriendshipService;

    public AccountController(AccountService accountService, UserInfoService userInfoService,
            FriendshipService FriendshipService) {
        this.accountService = accountService;
        this.userInfoService = userInfoService;
        this.FriendshipService = FriendshipService;
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
    @PostMapping("/updateInfo")
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
    @GetMapping("/info/{accountId}")
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
    @PostMapping("/friendship/add")
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
    @DeleteMapping("/friendship/remove")
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
    @GetMapping("/friendship/{accountId}")
    public ResponseEntity<List<Friendship>> getFriendship(@PathVariable Long accountId) {
        try {
            List<Friendship> friendship = FriendshipService.getAllFriends(accountId);
            return ResponseEntity.ok(friendship);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
