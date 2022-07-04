package com.altrkawi.client.service;

import com.altrkawi.client.entity.User;
import com.altrkawi.client.entity.VerificationToken;
import com.altrkawi.client.model.UserModel;

import java.util.Optional;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);

    VerificationToken generateVerificationToken(String oldToken);

    User findByEmail(String email);

    void createPasswordResetToken(User user, String token);

    String validatePasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    void changePassword(User user, String newPassword);

    boolean checkIfValidOldPassword(User user, String oldPassword);
}
