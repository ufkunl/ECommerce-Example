package com.ecommerce.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @developer -- ufukunal
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Detecting wrong argument parameters and return an error message to users to be corrected it.
     *
     * @param ex
     * @param request
     * @return
     */

    @ExceptionHandler(value = {ProductNotFound.class})
    protected ResponseEntity<Object> handleRuntimeProductException(Exception ex, WebRequest request) {
        String message = ex.getMessage();
        return handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(value = {CategoryNotFound.class})
    protected ResponseEntity<Object> handleRuntimeCategoryException(Exception ex, WebRequest request) {
        String message = ex.getMessage();
        return handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}
