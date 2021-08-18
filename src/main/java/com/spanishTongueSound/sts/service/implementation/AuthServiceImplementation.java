package com.spanishTongueSound.sts.service.implementation;

import com.spanishTongueSound.sts.dto.request.LoginRequest;
import com.spanishTongueSound.sts.dto.request.RefreshTokenRequest;
import com.spanishTongueSound.sts.dto.request.RegisterRequest;
import com.spanishTongueSound.sts.dto.response.AuthenticationResponse;
import com.spanishTongueSound.sts.exception.service.InvalidTokenException;
import com.spanishTongueSound.sts.exception.service.UserNotFoundWithUserIdException;
import com.spanishTongueSound.sts.model.NotificationEmail;
import com.spanishTongueSound.sts.model.User;
import com.spanishTongueSound.sts.model.VerificationToken;
import com.spanishTongueSound.sts.respository.UserRepository;
import com.spanishTongueSound.sts.respository.VerificationTokenRepository;
import com.spanishTongueSound.sts.security.JwtProvider;
import com.spanishTongueSound.sts.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthServiceImplementation implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    private final MailServiceImplementation mailServiceImplementation;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final RefreshTokenService refreshTokenService;

    @Autowired
    public AuthServiceImplementation(PasswordEncoder passwordEncoder,
                                     UserRepository userRepository,
                                     VerificationTokenRepository verificationTokenRepository,
                                     MailServiceImplementation mailServiceImplementation,
                                     AuthenticationManager authenticationManager,
                                     JwtProvider jwtProvider,
                                     RefreshTokenService refreshTokenService){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.verificationTokenRepository = verificationTokenRepository;
        this.mailServiceImplementation = mailServiceImplementation;
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
        this.refreshTokenService = refreshTokenService;
    }

    @Override
    @Transactional
    public void signup(RegisterRequest registerRequest) {
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreated(Instant.now());
        user.setEnable(false);
        User userCreated = userRepository.createUser(
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getCreated(),
                user.isEnable());
        System.out.println(userCreated);
//        generateVerificationToken(user);
        String token = generateVerificationToken(userCreated);
        mailServiceImplementation.sendMail(new NotificationEmail("Please Activate your Account",
                user.getEmail(), "Thanks you for signin up to Spring Reddit," +
                " please click on the below url to activate your account : " +
                "http://localhost:8080/api/auth/accountVerification/" + token));
    }

    @Transactional(readOnly = true)
    public User getCurrentUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return userRepository.findByUsername(principal.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User name not found - " + principal.getUsername()));
    }

    private String generateVerificationToken(User user){
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        System.out.println(token);
        verificationToken.setToken(token);
        verificationToken.setUserId(user.getUserId());
        System.out.println(verificationToken);
        //verificationTokenRepository.createToken(verificationToken.getToken()) ;
        verificationTokenRepository.createToken(verificationToken.getToken(), verificationToken.getUserId());
        //verificationTokenRepository.save(verificationToken);
        return token;

    }

    public void verifyAccount(String token) {
        Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
        verificationToken.orElseThrow(() -> new InvalidTokenException());
        fetchUserAndEnable(verificationToken.get());

    }

    @Transactional
    @Override
    public void fetchUserAndEnable(VerificationToken verificationToken) {
        Long userid = verificationToken.getUserId();
        User user = userRepository.findUserById(userid)
                .orElseThrow(() -> new UserNotFoundWithUserIdException(userid.toString()));

        user.setEnable(true);
        userRepository.updateEnableUser(user.getUserId(), user.isEnable());
    }

    public AuthenticationResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = jwtProvider.generateToken(authenticate);
        return AuthenticationResponse.builder()
                .authenticationToken(token)
                .refreshToken(refreshTokenService.generateRefreshToken().getToken())
                .expireAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
                .username(loginRequest.getUsername())
                .build();

    }
    public AuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.validateRefreshToken(refreshTokenRequest.getRefreshToken());
        String token = jwtProvider.generateTokenWithUserName(refreshTokenRequest.getUsername());
        return AuthenticationResponse.builder()
                .authenticationToken(token)
                .refreshToken(refreshTokenRequest.getRefreshToken())
                .expireAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
                .username(refreshTokenRequest.getUsername())
                .build();
    }
}
