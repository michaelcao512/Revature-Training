package dev.michaelcao512.socialmedia.Services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev.michaelcao512.socialmedia.Entities.Account;
import dev.michaelcao512.socialmedia.Entities.UserInfo;
import dev.michaelcao512.socialmedia.Exceptions.InvalidCredentialsException;
import dev.michaelcao512.socialmedia.Repositories.AccountRepository;
import dev.michaelcao512.socialmedia.Repositories.UserInfoRepository;
import dev.michaelcao512.socialmedia.dto.RegistrationRequest;

@Service
public class AccountService implements UserDetailsService {
    private final AccountRepository accountRepository;
    private final UserInfoRepository userInfoRepository;

    public AccountService(AccountRepository accountRepository, UserInfoRepository userInfoRepository) {
        this.accountRepository = accountRepository;
        this.userInfoRepository = userInfoRepository;
    }

    public Account registerAccount(RegistrationRequest registrationRequest) {
        // checking for non null required fields
        if (registrationRequest.getEmail() == null || registrationRequest.getPassword() == null
                || registrationRequest.getUsername() == null) {
            throw new IllegalArgumentException("Email, password, and username must be provided.");
        }

        // checking for empty required fields
        if (registrationRequest.getEmail().isEmpty() || registrationRequest.getPassword().isEmpty()
                || registrationRequest.getUsername().isEmpty()) {
            throw new IllegalArgumentException("Email, password, and username must be provided.");
        }
        // checking if email or username already exists
        if (accountRepository.existsByEmail(registrationRequest.getEmail())
                || accountRepository.existsByUsername(registrationRequest.getUsername())) {
            throw new IllegalArgumentException("Email or username already exists.");
        }

        Account newAccount = new Account();
        newAccount.setEmail(registrationRequest.getEmail());
        newAccount.setPassword(registrationRequest.getPassword());
        newAccount.setUsername(registrationRequest.getUsername());

        UserInfo userInfo = new UserInfo();
        userInfo.setAccount(newAccount);
        userInfo.setFirstName(registrationRequest.getFirstName());
        userInfo.setLastName(registrationRequest.getLastName());
        userInfo.setGender(registrationRequest.getGender());

        userInfoRepository.save(userInfo);
        newAccount.setUserInfo(userInfo);
        accountRepository.save(newAccount);

        return newAccount;
    }

    /**
     * Logs in an account given the provided email and password.
     * 
     * @param account The account to log in.
     * @return The account if the login is successful, null if the login fails.
     * @throws InvalidCredentialsException If the email or password is incorrect, or
     *                                     if the account is null.
     * @throws IllegalArgumentException    If the account is null.
     */
    public Account loginAccount(Account account) {
        if (account.getEmail() == null || account.getPassword() == null) {
            throw new IllegalArgumentException("Email and password must be provided.");
        }

        // checking if account exists
        Account newAccount = accountRepository.findByEmail(account.getEmail());
        if (newAccount == null) {
            throw new InvalidCredentialsException("Account not found.");
        }

        // checking if password matches
        if (!newAccount.getPassword().equals(account.getPassword())) {
            throw new InvalidCredentialsException("Invalid password.");
        }

        return newAccount;
    }

    public Account getAccountByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    public Account getAccountByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("User not found.");
        }
        return account;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

}
