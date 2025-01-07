package com.tawfeek.quiz_api.exception;

public class ConflictException extends RuntimeException {
    public ConflictException(){
        super();
    }
    public ConflictException(String message) {
        super(message);

    }
}
