package com.library.book.library;

import jdk.jfr.ContentType;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<ErrorResponse> BookNotFound(BookNotFoundException ex) {

        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), "1001", "404");

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errorResponse);
    }

    @ExceptionHandler(InvalidIsbnException.class)
    public ResponseEntity<ErrorResponse> invalidIsbn(InvalidIsbnException ex) {

        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), "1002", "400");
        return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errorResponse);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> GenericException(Exception e) {

        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), "1000", "500");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .contentType(MediaType.APPLICATION_JSON)
                .body(errorResponse);

    }


}
