package com.lawlayui.e_commerce.E_Commerce.custom_exception;

public class ResourceNotFoundException extends BaseException{
    public ResourceNotFoundException(Long id) {
        super(404 ,"Resource not found with id " + id);
    }
    public ResourceNotFoundException(String name, Long id) {
        super(404, name + " not found with id " + id);
    }
    public ResourceNotFoundException() {
        super(404, "Resouce not found");
    }
    public ResourceNotFoundException(String msg)  {
        super(404 ,msg);
    }
}
