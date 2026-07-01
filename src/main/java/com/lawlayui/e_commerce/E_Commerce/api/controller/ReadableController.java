package com.lawlayui.e_commerce.E_Commerce.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.lawlayui.e_commerce.E_Commerce.dto.response.BaseResponse;

public interface ReadableController<Res extends BaseResponse> {
    @GetMapping
    default ResponseEntity<List<Res>> getAll(@RequestParam(defaultValue = "5") int size, @RequestParam(defaultValue = "0") int page) throws Exception {return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();}
    @GetMapping("/{id}")
    default ResponseEntity<Res> getById(@PathVariable Long id) throws Exception {return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();}
}
