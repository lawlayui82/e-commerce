package com.lawlayui.e_commerce.E_Commerce.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface DeletableController {
    @DeleteMapping("/{id}")
    default ResponseEntity<?> delete(@PathVariable Long id) throws Exception {return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();} 
}
