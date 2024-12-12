package dev.michaelcao512.socialmedia.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.michaelcao512.socialmedia.Entities.Account;
import dev.michaelcao512.socialmedia.Entities.UserInfo;
import dev.michaelcao512.socialmedia.Repositories.AccountRepository;
import dev.michaelcao512.socialmedia.Repositories.UserInfoRepository;
import dev.michaelcao512.socialmedia.dto.RegistrationRequest;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserInfoRepository userInfoRepository;

    public AccountService(AccountRepository accountRepository, UserInfoRepository userInfoRepository) {
        this.accountRepository = accountRepository;
        this.userInfoRepository = userInfoRepository;
    }

    public Account registerAccount(RegistrationRequest registrationRequest) {
        if (accountRepository.existsByEmail(registrationRequest.getEmail())) {
            return null;
        }

        Account newAccount = new Account();
        newAccount.setEmail(registrationRequest.getEmail());
        newAccount.setPassword(registrationRequest.getPassword());
        newAccount.setUsername(registrationRequest.getUsername());
        
        accountRepository.save(newAccount);

        UserInfo userInfo = new UserInfo();
        userInfo.setAccount(newAccount);
        userInfo.setFirstName(registrationRequest.getFirstName());
        userInfo.setLastName(registrationRequest.getLastName());
        userInfo.setGender(registrationRequest.getGender());

        userInfoRepository.save(userInfo);

        return newAccount;
    }


    public Account loginAccount(Account account) {
        Account newAccount = accountRepository.findByEmail(account.getEmail());
        if (newAccount.getPassword().equals(account.getPassword())) {
            return newAccount;
        }
        return null;
    }
}
