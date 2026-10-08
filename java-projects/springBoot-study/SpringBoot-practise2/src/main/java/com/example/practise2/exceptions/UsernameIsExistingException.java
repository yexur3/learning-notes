package com.example.practise2.exceptions;

public class UsernameIsExistingException extends RuntimeException{
    public UsernameIsExistingException(String username){
        super("Username " + username + " is already existing");
    }
}
