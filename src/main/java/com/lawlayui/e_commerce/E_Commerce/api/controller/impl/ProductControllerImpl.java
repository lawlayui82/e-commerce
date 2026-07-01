package com.lawlayui.e_commerce.E_Commerce.api.controller.impl;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lawlayui.e_commerce.E_Commerce.api.controller.ProductController;
import com.lawlayui.e_commerce.E_Commerce.dto.request.product.ProductCreateRequest;
import com.lawlayui.e_commerce.E_Commerce.dto.request.product.ProductUpdateRequest;
import com.lawlayui.e_commerce.E_Commerce.dto.response.BaseResponse;
import com.lawlayui.e_commerce.E_Commerce.dto.response.product.ProductReadResponse;
import com.lawlayui.e_commerce.E_Commerce.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/product")
public class ProductControllerImpl implements ProductController{

    private ProductService productService;

    public ProductControllerImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<BaseResponse> create(@Valid @RequestBody ProductCreateRequest createRequest) throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(productService.create(createRequest));
    }

    @Override
    public ResponseEntity<?> delete(Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<BaseResponse> update(@Valid @RequestBody ProductUpdateRequest updateRequest, Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(productService.update(updateRequest, id));
    }

    @Override
    public ResponseEntity<List<ProductReadResponse>> getAll(int size, int page) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAll(PageRequest.of(page, size)));
    }

    @Override
    public ResponseEntity<ProductReadResponse> getById(Long id) throws Exception{
        return ResponseEntity.status(HttpStatus.OK).body(productService.getById(id));
    }
    
}
