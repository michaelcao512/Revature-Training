package dev.michaelcao512.socialmedia.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.michaelcao512.socialmedia.Entities.Account;
import dev.michaelcao512.socialmedia.Entities.UserInfo;
import dev.michaelcao512.socialmedia.Services.AccountService;
import dev.michaelcao512.socialmedia.Services.UserInfoService;
import dev.michaelcao512.socialmedia.dto.RegistrationRequest;
import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;
    
    public AccountController(AccountService accountService ) {
        this.accountService = accountService;
    }

    // registering a new account
    // RegistrationRequest object in body
    // if email already exists, return bad request
    // if registration request is valid, return account
    @PostMapping("/register")
    public ResponseEntity<Account> registerAccount(@RequestBody RegistrationRequest registrationRequest) {
        Account newAccount = accountService.registerAccount(registrationRequest);
        if (newAccount == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(newAccount);
    }

    // logging in
    // Account object with email and password in body
    // if password doesn't match, return bad request
    // if password matches, return account
    @GetMapping("/login")
    public ResponseEntity<Account> login(@RequestBody Account loginInfo) {
        Account account = accountService.loginAccount(loginInfo);
        if (account == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(account);
    }
}
