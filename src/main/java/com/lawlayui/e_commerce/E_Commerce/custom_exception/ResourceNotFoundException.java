package com.lawlayui.e_commerce.E_Commerce.custom_exception;

public class ResourceNotFoundException extends Exception{
    public ResourceNotFoundException(Long id) {
        super("Resource not found with id: " + id);
    }
    public ResourceNotFoundException(String name, Long id) {
        super(name + " not found with id: " + id);
    }
    public ResourceNotFoundException() {
        super("Resouce not found");
    }
    public ResourceNotFoundException(String msg)  {
        super(msg);
    }
}
