package com.tracktainment.reviewmanager.exception;

public class AuthorizationFailedException extends BusinessException {

    public AuthorizationFailedException(String message) {
        super(
                ExceptionCode.CLIENT_NOT_AUTHORIZED,
                message
        );
    }
}
