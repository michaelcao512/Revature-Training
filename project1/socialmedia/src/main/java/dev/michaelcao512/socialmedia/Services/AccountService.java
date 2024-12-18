package dev.michaelcao512.socialmedia.Services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.michaelcao512.socialmedia.Entities.Account;
import dev.michaelcao512.socialmedia.Entities.UserInfo;
import dev.michaelcao512.socialmedia.Exceptions.EmailAlreadyExistsException;
import dev.michaelcao512.socialmedia.Exceptions.InvalidCredentialsException;
import dev.michaelcao512.socialmedia.Exceptions.UsernameAlreadyExistsException;
import dev.michaelcao512.socialmedia.Repositories.AccountRepository;
import dev.michaelcao512.socialmedia.Repositories.UserInfoRepository;
import dev.michaelcao512.socialmedia.dto.RegistrationRequest;

@Service
public class AccountService implements UserDetailsService {
    private final AccountRepository accountRepository;
    private final UserInfoRepository userInfoRepository;
    private final ApplicationContext applicationContext;

    public AccountService(AccountRepository accountRepository, UserInfoRepository userInfoRepository,
            ApplicationContext applicationContext) {
        this.accountRepository = accountRepository;
        this.userInfoRepository = userInfoRepository;
        this.applicationContext = applicationContext;

    }

    private PasswordEncoder getPasswordEncoder() {
        return applicationContext.getBean(PasswordEncoder.class);
    }

    public Account registerAccount(RegistrationRequest registrationRequest) {
        Logger logger = LoggerFactory.getLogger(AccountService.class);

        String email = registrationRequest.getEmail();
        String password = registrationRequest.getPassword();
        String username = registrationRequest.getUsername();
        String firstName = registrationRequest.getFirstName();
        String lastName = registrationRequest.getLastName();
        String gender = registrationRequest.getGender();
        // checking for non null required fields
        if (email == null || password == null || username == null) {
            throw new IllegalArgumentException("Email, password, and username must be provided.");
        }

        // checking for empty required fields
        if (email.isEmpty() || password.isEmpty() || username.isEmpty()) {
            throw new IllegalArgumentException("Email, password, and username must be provided.");
        }

        // checking if email or username already exists
        if (accountRepository.existsByUsername(username)) {
            throw new UsernameAlreadyExistsException();
        }
        if (accountRepository.existsByEmail(email)) {
            throw new EmailAlreadyExistsException();
        }

        password = getPasswordEncoder().encode(password);

        Account newAccount = new Account();
        newAccount.setEmail(email);
        newAccount.setPassword(password);
        newAccount.setUsername(username);

        Account savedAccount = accountRepository.save(newAccount);
        logger.info("saved account");

        UserInfo userInfo = new UserInfo();
        userInfo.setAccount(savedAccount);
        userInfo.setFirstName(firstName);
        userInfo.setLastName(lastName);
        userInfo.setGender(gender);

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
     * @throws InvalidCredentialsException If the username or password is incorrect
     * @throws IllegalArgumentException    If the account is null.
     */
    public Account loginAccount(Account account) {
        String email = account.getEmail();
        String password = account.getPassword();
        String username = account.getUsername();
        // checking for non null required fields
        if (username == null || password == null) {
            throw new IllegalArgumentException("Email and password must be provided.");
        }

        // checking if account exists
        Account newAccount = accountRepository.findByUsername(username);
        if (newAccount == null) {
            throw new InvalidCredentialsException("Account not found.");
        }

        password = getPasswordEncoder().encode(password);
        // checking if password matches
        if (!password.equals(password)) {
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

    public Account getAccountById(Long accountId) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isEmpty()) {
            throw new IllegalArgumentException("Account doesn't exist");
        }
        return account.get();

    }

}
