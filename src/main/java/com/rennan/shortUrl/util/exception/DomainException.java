package com.rennan.shortUrl.util.exception;

import com.rennan.shortUrl.util.Enum.ErrorType;

public class DomainException extends Exception {

    private ErrorType errorType;


    public DomainException(ErrorType errorType){
        this.errorType = errorType;
    }

    public ErrorType getErrorType(){
        return this.errorType;
    }

}
