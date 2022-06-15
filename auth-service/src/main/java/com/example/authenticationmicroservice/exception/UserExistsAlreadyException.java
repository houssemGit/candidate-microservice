package com.example.authenticationmicroservice.exception;


public class UserExistsAlreadyException extends Throwable {
    public UserExistsAlreadyException(String username) {
        super(" user with username [" + username + "] exists already");
    }
}
