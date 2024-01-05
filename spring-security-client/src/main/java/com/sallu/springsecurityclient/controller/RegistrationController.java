package com.sallu.springsecurityclient.controller;

import com.sallu.springsecurityclient.entity.User;
import com.sallu.springsecurityclient.event.RegistrationCompleteEvent;
import com.sallu.springsecurityclient.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user, HttpServletRequest request) {
        userService.registerUser(user);
        String url = "http://" +
                request.getServerName() +
                ":" +
                request.getServerPort() +
                request.getContextPath();

        publisher.publishEvent(new RegistrationCompleteEvent(user, url));
        return "User registered";
    }

    @GetMapping("/verify")
    public String verifyRegistration(@RequestParam("token") String token) {
        String result = userService.validateRegistrationToken(token);
        if(result.equals("valid")) {
            return "User verified successfully";
        }
        else if(result.equals("expired")) {
            return "The token has been expired";
        }
        else {
            return "Invalid token passed";
        }
    }

}
