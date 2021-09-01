package com.spanishTongueSound.sts.helper.shared;

import com.spanishTongueSound.sts.exception.helper.shared.ShouldNotExistEntityInDatabaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CheckIfNotNullOrEmptyLong {


    Logger logger = LoggerFactory.getLogger(CheckIfNotNullOrEmptyLong.class);

    public CheckIfNotNullOrEmptyLong() {
    }

    public void check(Long longNumber){
        logger.info("Checking if Null or Zero this " + longNumber);
        if(!isZeroOrNull(longNumber))
            throw new ShouldNotExistEntityInDatabaseException();

    }

    private boolean isZeroOrNull(Long longNumber) {
        return !(longNumber != null && !longNumber.equals(0L));
    }
}
