package com.lawlayui.e_commerce.E_Commerce.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lawlayui.e_commerce.E_Commerce.dto.request.BaseRequest;
import com.lawlayui.e_commerce.E_Commerce.dto.response.BaseResponse;

import jakarta.validation.Valid;

public interface CrateableController<Req extends BaseRequest, Res extends BaseResponse> {
    @PostMapping
    default ResponseEntity<Res> create(@Valid @RequestBody Req createRequest) throws Exception {return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();}
}
