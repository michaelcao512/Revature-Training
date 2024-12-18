package dev.michaelcao512.socialmedia.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.michaelcao512.socialmedia.Configurations.JwtUtils;
import dev.michaelcao512.socialmedia.Entities.Account;
import dev.michaelcao512.socialmedia.Services.AccountService;
import dev.michaelcao512.socialmedia.dto.JwtResponse;
import dev.michaelcao512.socialmedia.dto.LoginRequest;
import dev.michaelcao512.socialmedia.dto.RegistrationRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AccountService accountService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtils jwtUtils;

    @RequestMapping("/login")
    public ResponseEntity<JwtResponse> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.username(), loginRequest.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.genereateJwtToken(authentication);

        Account account = (Account) authentication.getPrincipal();

        return ResponseEntity.ok(
                new JwtResponse(jwt, account.getAccountId(), account.getUsername(), account.getEmail()));
    }

    @RequestMapping("/register")
    public ResponseEntity<Account> register(@RequestBody RegistrationRequest registrationRequest) {
        Account account;
        try {
            account = accountService.registerAccount(registrationRequest);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(account);
    }
}