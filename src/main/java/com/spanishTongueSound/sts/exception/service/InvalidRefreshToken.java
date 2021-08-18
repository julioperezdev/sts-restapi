package com.spanishTongueSound.sts.exception.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidRefreshToken extends RuntimeException{

    Logger logger = LoggerFactory.getLogger(InvalidRefreshToken.class);

    public InvalidRefreshToken(){
        logger.error("Invalid refresh Token");
    }
}
