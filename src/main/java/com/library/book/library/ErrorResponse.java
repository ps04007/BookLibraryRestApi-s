package com.library.book.library;

import lombok.Data;

@Data
public class ErrorResponse {

    private String errorMessage;
    private String errorCode;
    private String statusCode;

    public ErrorResponse(String errorMessage,String errorCode,String statusCode){
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
        this.statusCode=statusCode;

    }



}
