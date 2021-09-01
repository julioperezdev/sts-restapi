package com.spanishTongueSound.sts.exception;

import com.spanishTongueSound.sts.exception.helper.shared.HelperCheckIfNullOrEmptyStringException;
import com.spanishTongueSound.sts.exception.helper.shared.HelperCheckIfNullOrZeroLongException;
import com.spanishTongueSound.sts.exception.helper.shared.HelperStringCanNotHaveAnyNumberException;
import com.spanishTongueSound.sts.exception.helper.shared.ShouldNotExistEntityInDatabaseException;
import org.springframework.http.HttpStatus;

public enum SupportedExceptions {

    //Categories Controller Exceptions
    //..

    //Author Service Exceptions

    //Helper Exceptions
    SHOULD_NOT_EXIST_IN_DATABASE(ShouldNotExistEntityInDatabaseException.class, HttpStatus.CONFLICT),
    CATEGORY_BAD_PREREQUISITES(HelperCheckIfNullOrEmptyStringException.class, HttpStatus.BAD_REQUEST),
    CATEGORY_NOT_BE_ZERO(HelperCheckIfNullOrZeroLongException.class, HttpStatus.PRECONDITION_FAILED),
    HELPER_STRING_CANT_HAVE_ANY_NUMBER(HelperStringCanNotHaveAnyNumberException.class, HttpStatus.PRECONDITION_FAILED);



    private Class<? extends Throwable> exceptionClass;
    private HttpStatus status;
    private SupportedExceptions(Class<? extends Throwable>exception, HttpStatus status){
        this.exceptionClass = exception;
        this.status = status;
    }

    public Class <? extends Throwable> getExceptionClass(){
        return this.exceptionClass;
    }

    public HttpStatus getStatus(){
        return this.status;
    }
}
