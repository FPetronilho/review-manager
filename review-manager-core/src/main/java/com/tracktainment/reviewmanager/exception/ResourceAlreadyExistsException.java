package com.tracktainment.reviewmanager.exception;

public class ResourceAlreadyExistsException extends BusinessException {

    public static final String ERROR_MESSAGE = "%s %s already exists.";

    public ResourceAlreadyExistsException(Class<?> clazz, String resourceAttribute) {
        super(
                ExceptionCode.RESOURCE_ALREADY_EXISTS,
                String.format(ERROR_MESSAGE, clazz.getSimpleName(), resourceAttribute)
        );
    }
}
