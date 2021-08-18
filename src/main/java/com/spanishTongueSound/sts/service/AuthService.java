package com.spanishTongueSound.sts.service;

import com.spanishTongueSound.sts.dto.request.LoginRequest;
import com.spanishTongueSound.sts.dto.request.RegisterRequest;
import com.spanishTongueSound.sts.dto.response.AuthenticationResponse;
import com.spanishTongueSound.sts.model.VerificationToken;
import org.springframework.transaction.annotation.Transactional;

public interface AuthService {

    void signup(RegisterRequest registerRequest);

    //String generateVerificationToken(User user);

    void verifyAccount(String token);


    @Transactional
    void fetchUserAndEnable(VerificationToken verificationToken);

    AuthenticationResponse login(LoginRequest loginRequest);
}
