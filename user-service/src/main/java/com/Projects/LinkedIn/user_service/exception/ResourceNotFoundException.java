package com.Projects.LinkedIn.user_service.exception;


public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
