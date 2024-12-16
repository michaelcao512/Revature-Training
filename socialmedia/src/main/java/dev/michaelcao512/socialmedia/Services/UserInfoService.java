package dev.michaelcao512.socialmedia.Services;

import org.springframework.stereotype.Service;

import dev.michaelcao512.socialmedia.Entities.UserInfo;
import dev.michaelcao512.socialmedia.Repositories.UserInfoRepository;

@Service
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;

    public UserInfoService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public UserInfo updateUserInfo(UserInfo userInfo) {
        UserInfo existingUserInfo = userInfoRepository.findById(userInfo.getUserInfoId()).orElse(null);
        if (existingUserInfo == null) {
            throw new IllegalArgumentException("User info not found");
        }
        if (userInfo.getFirstName() != null && !userInfo.getFirstName().isEmpty()) {
            existingUserInfo.setFirstName(userInfo.getFirstName());
        }
        if (userInfo.getLastName() != null && !userInfo.getLastName().isEmpty()) {
            existingUserInfo.setLastName(userInfo.getLastName());
        }
        if (userInfo.getGender() != null && !userInfo.getGender().isEmpty()) {
            existingUserInfo.setGender(userInfo.getGender());
        }
        userInfoRepository.save(existingUserInfo);
        return existingUserInfo;
    }

}
