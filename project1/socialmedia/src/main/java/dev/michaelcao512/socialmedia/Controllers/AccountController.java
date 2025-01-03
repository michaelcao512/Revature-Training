package dev.michaelcao512.socialmedia.Controllers;

import dev.michaelcao512.socialmedia.Entities.Account;
import dev.michaelcao512.socialmedia.Services.AccountService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * Retrieves all accounts.
     *
     * @return a list of all accounts
     */
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    /**
     * Retrieves the account associated with the given account id.
     *
     * @param accountId the id of the account to retrieve
     * @return the account associated with the given id
     */
    @GetMapping("/{accountId}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.getAccountById(accountId));
    }

    /**
     * 
     * Updates the account information associated with the given account id.
     *
     * The object in the request body should contain the fields to be updated.
     * If the field is not present in the request body, it will not be updated.
     *
     * @param accountId      the id of the account to be updated
     * @param accountDetails the details to update the account with
     * @return the updated account
     */

    // @PatchMapping("/{accountId}")
    // public ResponseEntity<Account> updateAccount(@PathVariable Long accountId,
    // @RequestBody Account accountDetails) {
    // Account updatedAccount = accountService.updateAccount(accountId,
    // accountDetails);
    // return ResponseEntity.ok(updatedAccount);
    // }

    @GetMapping("/getAccountOfComment/{commentId}")
    public ResponseEntity<Account> getAccountOfComment(@PathVariable Long commentId) {
        Account account = accountService.getAccountOfComment(commentId);
        return ResponseEntity.ok(account);
    }

    @GetMapping("/getAccountOfPost/{postId}")
    public ResponseEntity<Account> getAccountByPostId(@PathVariable Long postId) {
        return ResponseEntity.ok(accountService.getAccountOfPost(postId));
    }

    @GetMapping("/getFollowing/{accountId}")
    public ResponseEntity<List<Account>> getMethodName(@PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.getFollowing(accountId));
    }

    @GetMapping("/getFollowers/{accountId}")
    public ResponseEntity<List<Account>> getFollowers(@PathVariable Long accountId) {
        return ResponseEntity.ok(accountService.getFollowers(accountId));
    }
    

}