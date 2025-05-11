package com.tracktainment.reviewmanager.exception;

import com.tracktainment.reviewmanager.mapper.ExceptionMapperEntryPointRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler {

    private final ExceptionMapperEntryPointRest mapper;

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionDto> handleBusinessException(BusinessException e) {
        return new ResponseEntity<>(
                mapper.toExceptionDto(e),
                new HttpHeaders(),
                HttpStatusCode.valueOf(e.getHttpStatusCode())
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleGlobalException (Exception e) {
        return handleBusinessException(
                new InternalServerErrorException(e.getMessage())
        );
    }
}
