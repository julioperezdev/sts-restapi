package com.spanishTongueSound.sts.exception.helper.shared;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelperStringCanNotHaveAnyNumberException extends RuntimeException{

    Logger logger = LoggerFactory.getLogger(HelperStringCanNotHaveAnyNumberException.class);

    public HelperStringCanNotHaveAnyNumberException(String particularString) {
        logger.error("Can not use a Number in this String :" + particularString);
        falseResult();
    }

    public boolean falseResult(){
        return false;
    }
}
