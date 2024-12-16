package dev.michaelcao512.socialmedia.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.michaelcao512.socialmedia.Entities.Account;
import dev.michaelcao512.socialmedia.Exceptions.InvalidCredentialsException;
import dev.michaelcao512.socialmedia.Services.AccountService;
import dev.michaelcao512.socialmedia.dto.RegistrationRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // registering a new account
    // RegistrationRequest object in body
    // if email already exists, return bad request
    // if registration request is valid, return account
    @PostMapping("/register")
    public ResponseEntity<Account> registerAccount(@RequestBody RegistrationRequest registrationRequest) {
        try {
            Account account = accountService.registerAccount(registrationRequest);
            return ResponseEntity.ok(account);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // logging in
    // Account object with email and password in body
    // if email doesn't exist, return bad request
    // if email or password is null, return bad request
    // if password doesn't match, return bad request
    // if password matches, return account
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
}
