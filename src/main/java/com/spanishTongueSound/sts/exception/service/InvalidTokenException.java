package com.spanishTongueSound.sts.exception.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvalidTokenException extends RuntimeException{

    Logger logger = LoggerFactory.getLogger(InvalidTokenException.class);

    public InvalidTokenException(){
        logger.error("Invalid Token");
    }
}
