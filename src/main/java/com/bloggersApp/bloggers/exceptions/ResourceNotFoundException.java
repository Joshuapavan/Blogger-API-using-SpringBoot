package com.bloggersApp.bloggers.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    String resourceName;

    String fieldName;

    Integer id;

    public ResourceNotFoundException(String resourceName, String fieldName, Integer id) {
        super(String.format("%s is not found with %s : %s", new Object[]{resourceName, fieldName, id}));
        this.fieldName = fieldName;
        this.resourceName = resourceName;
        this.id = id;

    }
}
