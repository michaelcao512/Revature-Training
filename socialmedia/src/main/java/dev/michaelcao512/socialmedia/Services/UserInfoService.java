package dev.michaelcao512.socialmedia.Services;

import org.springframework.stereotype.Service;

import dev.michaelcao512.socialmedia.Repositories.UserInfoRepository;

@Service
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;
    private final AccountService accountService;
    public UserInfoService(UserInfoRepository userInfoRepository, AccountService accountService) {
        this.userInfoRepository = userInfoRepository;
        this.accountService = accountService;
    }


}
