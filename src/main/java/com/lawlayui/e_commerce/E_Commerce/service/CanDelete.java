package com.lawlayui.e_commerce.E_Commerce.service;


public interface CanDelete {
    default void deleteById(Long id) {return;}
    default void deleteAll() throws Exception{return;}
}
