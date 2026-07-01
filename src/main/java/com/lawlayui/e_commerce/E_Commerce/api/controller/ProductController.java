package com.lawlayui.e_commerce.E_Commerce.api.controller;


import com.lawlayui.e_commerce.E_Commerce.dto.request.product.ProductCreateRequest;
import com.lawlayui.e_commerce.E_Commerce.dto.request.product.ProductUpdateRequest;
import com.lawlayui.e_commerce.E_Commerce.dto.response.BaseResponse;
import com.lawlayui.e_commerce.E_Commerce.dto.response.product.ProductReadResponse;

public interface ProductController extends CrateableController<ProductCreateRequest, BaseResponse>, DeletableController, PatchableController<ProductUpdateRequest, BaseResponse>, ReadableController<ProductReadResponse> {
    
}
