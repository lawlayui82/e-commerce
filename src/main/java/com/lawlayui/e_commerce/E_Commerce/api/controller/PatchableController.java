package com.lawlayui.e_commerce.E_Commerce.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.lawlayui.e_commerce.E_Commerce.dto.request.BaseRequest;
import com.lawlayui.e_commerce.E_Commerce.dto.response.BaseResponse;

import jakarta.validation.Valid;

public interface PatchableController<Req extends BaseRequest, Res extends BaseResponse>{
    @PatchMapping("/{id}")
    default ResponseEntity<Res> update(@Valid @RequestBody Req updateRequest, @PathVariable Long id) throws Exception {return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();}
}
