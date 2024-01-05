package com.sallu.springsecurityclient.service;

import com.sallu.springsecurityclient.entity.User;
import com.sallu.springsecurityclient.entity.VerificationToken;
import com.sallu.springsecurityclient.repository.UserRepository;
import com.sallu.springsecurityclient.repository.VerificationTokenRepository;
import jakarta.transaction.Transactional;
import org.apache.juli.VerbatimFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    VerificationTokenRepository verificationTokenRepository;

    @Override
    public void registerUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void saveVerificationTokenForUser(User user, String token) {
        VerificationToken verificationToken = new VerificationToken(token, user);
        verificationTokenRepository.save(verificationToken);
    }

    @Override
    public String validateRegistrationToken(String token) {
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token);

        if(verificationToken == null) {
            return "invalid";
        }

        if(verificationToken.getExpirationTime().isEqual(LocalDateTime.now())
        || verificationToken.getExpirationTime().isAfter(LocalDateTime.now())) {
            enableUser(verificationToken.getUser().getId());
            return "valid";
        }
        else {
            return "expired";
        }
    }

    @Transactional
    private void enableUser(long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if(user != null) {
            user.setEnabled(true);
            userRepository.save(user);
        }
    }
}
