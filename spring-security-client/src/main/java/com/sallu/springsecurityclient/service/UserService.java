package com.sallu.springsecurityclient.service;

import com.sallu.springsecurityclient.entity.User;

public interface UserService {
    void registerUser(User user);

    void saveVerificationTokenForUser(User user, String token);

    String validateRegistrationToken(String token);

}
