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

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
    public ErrorResponse() {}



}
