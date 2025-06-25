package com.library.book.library;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorResponse> BookNotFound(BookNotFoundException ex) {

        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), "1001", "404");

        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(404));
    }

    @ExceptionHandler(InvalidIsbnException.class)
    public ResponseEntity<ErrorResponse> invalidIsbn(InvalidIsbnException ex) {

        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), "1002", "400");
        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(400));

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> GenericException(Exception e) {

        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), "1000", "500");

        return new ResponseEntity<>(errorResponse, HttpStatusCode.valueOf(500));

    }


}
