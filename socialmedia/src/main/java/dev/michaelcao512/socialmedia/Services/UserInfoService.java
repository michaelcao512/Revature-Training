package dev.michaelcao512.socialmedia.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.michaelcao512.socialmedia.Repositories.UserInfoRepository;

@Service
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;
    public UserInfoService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }
    
}
