package com.altrkawi.client.event.listener;

import com.altrkawi.client.entity.User;
import com.altrkawi.client.event.RegistrationCompleteEvent;
import com.altrkawi.client.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // create the verification token for the user...
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);
        // send mail to user
        String url = event.getApplicationUrl() + "verifyRegistration?token=" + token;

        // send verification
        log.info("Click the link to verify your account: {}", url);
    }
}
