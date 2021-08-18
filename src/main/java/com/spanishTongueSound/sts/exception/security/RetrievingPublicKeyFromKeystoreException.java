package com.spanishTongueSound.sts.exception.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RetrievingPublicKeyFromKeystoreException extends RuntimeException{

    Logger logger = LoggerFactory.getLogger(RetrievingPublicKeyFromKeystoreException.class);

    public RetrievingPublicKeyFromKeystoreException(){
        logger.error("Exception occurred while retrieving public key from keystore");
    }
}
