package com.sallu.springsecurityclient.event.listener;

import com.sallu.springsecurityclient.entity.User;
import com.sallu.springsecurityclient.event.RegistrationCompleteEvent;
import com.sallu.springsecurityclient.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    @Autowired
    UserService userService;
    Logger logger = LogManager.getLogger(RegistrationCompleteEventListener.class);
    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(user, token);

        String url = event.getUrl() + "/verify?token=" + token;
        logger.info("Click the link to verify your account : {}", url);
    }
}
