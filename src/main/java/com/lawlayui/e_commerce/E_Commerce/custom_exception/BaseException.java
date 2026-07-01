package com.lawlayui.e_commerce.E_Commerce.custom_exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends Exception {
    private int errorCode;
    private String message;

    public BaseException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }
}
