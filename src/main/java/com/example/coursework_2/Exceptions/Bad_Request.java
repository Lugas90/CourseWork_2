package com.example.coursework_2.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class Bad_Request extends RuntimeException{
    public Bad_Request() {
    }

    public Bad_Request(String message) {
        super(message);
    }

    public Bad_Request(String message, Throwable cause) {
        super(message, cause);
    }

    public Bad_Request(Throwable cause) {
        super(cause);
    }

    public Bad_Request(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
