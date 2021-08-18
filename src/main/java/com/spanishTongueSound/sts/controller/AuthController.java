package com.spanishTongueSound.sts.controller;


import com.spanishTongueSound.sts.dto.request.LoginRequest;
import com.spanishTongueSound.sts.dto.request.RefreshTokenRequest;
import com.spanishTongueSound.sts.dto.request.RegisterRequest;
import com.spanishTongueSound.sts.dto.response.AuthenticationResponse;
import com.spanishTongueSound.sts.dto.response.RestResponse;
import com.spanishTongueSound.sts.service.implementation.AuthServiceImplementation;
import com.spanishTongueSound.sts.service.implementation.RefreshTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthServiceImplementation authServiceImplementation;
    private final RefreshTokenService refreshTokenService;

    @Autowired
    public AuthController(AuthServiceImplementation authServiceImplementation,
                          RefreshTokenService refreshTokenService) {
        this.authServiceImplementation = authServiceImplementation;
        this.refreshTokenService = refreshTokenService;
    }

    @PostMapping("/signup")
    public RestResponse<?> signup(@RequestBody RegisterRequest registerRequest) {
        authServiceImplementation.signup(registerRequest);
        return new RestResponse<>(HttpStatus.OK, "User Register Successfully");
    }

    @GetMapping("/accountVerification/{token}")
    public RestResponse<?> verifyAccount(@PathVariable String token) {
        authServiceImplementation.verifyAccount(token);
        return new RestResponse<>(HttpStatus.OK, "Account Activate Successfully");

    }

    @PostMapping("/login")
    public RestResponse<AuthenticationResponse> login(@RequestBody LoginRequest loginRequest) {

        AuthenticationResponse authenticationResponse = authServiceImplementation.login(loginRequest);
        System.out.println(authenticationResponse);
        return new RestResponse<>(HttpStatus.OK, authenticationResponse);

    }

    @PostMapping("/refresh/token")
    public AuthenticationResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        return authServiceImplementation.refreshToken(refreshTokenRequest);
    }

    @PostMapping("/logout")
    public RestResponse<String> logout(@RequestBody RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.deleteRefreshToken(refreshTokenRequest.getRefreshToken());
        return new RestResponse<>(HttpStatus.OK, "Refresh token deleted successfully");
    }

}


