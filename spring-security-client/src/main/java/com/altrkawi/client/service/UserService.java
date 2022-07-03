package com.altrkawi.client.service;

import com.altrkawi.client.entity.User;
import com.altrkawi.client.entity.VerificationToken;
import com.altrkawi.client.model.UserModel;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);

    VerificationToken generateVerificationToken(String oldToken);
}
