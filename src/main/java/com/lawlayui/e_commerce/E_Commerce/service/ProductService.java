package com.lawlayui.e_commerce.E_Commerce.service;

import com.lawlayui.e_commerce.E_Commerce.dto.request.product.ProductCreateRequest;
import com.lawlayui.e_commerce.E_Commerce.dto.request.product.ProductUpdateRequest;
import com.lawlayui.e_commerce.E_Commerce.dto.response.BaseResponse;
import com.lawlayui.e_commerce.E_Commerce.dto.response.product.ProductReadResponse;

public interface ProductService extends CanCreate<ProductCreateRequest, BaseResponse>, CanDelete, CanRead<ProductReadResponse>, CanUpdate<ProductUpdateRequest, BaseResponse> {

}
