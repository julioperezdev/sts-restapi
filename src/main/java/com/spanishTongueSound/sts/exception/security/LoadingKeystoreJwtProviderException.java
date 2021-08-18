package com.spanishTongueSound.sts.exception.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoadingKeystoreJwtProviderException extends RuntimeException{

    Logger logger = LoggerFactory.getLogger(LoadingKeystoreJwtProviderException.class);

    public LoadingKeystoreJwtProviderException(){
        logger.error("Exception occurred while loading keystore");
    }
}
