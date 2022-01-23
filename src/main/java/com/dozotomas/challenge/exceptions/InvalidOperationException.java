package com.dozotomas.challenge.exceptions;

import lombok.AllArgsConstructor;


public class InvalidOperationException extends Exception{
    public InvalidOperationException(String message) {
        super(message);
    }
}
