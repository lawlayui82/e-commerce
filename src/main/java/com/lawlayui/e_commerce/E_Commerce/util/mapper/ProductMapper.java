package com.lawlayui.e_commerce.E_Commerce.util.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.lawlayui.e_commerce.E_Commerce.dto.request.product.ProductCreateRequest;
import com.lawlayui.e_commerce.E_Commerce.dto.request.product.ProductUpdateRequest;
import com.lawlayui.e_commerce.E_Commerce.dto.response.product.ProductReadResponse;
import com.lawlayui.e_commerce.E_Commerce.entity.Product;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper extends GenericMapper<Product, ProductCreateRequest, ProductUpdateRequest, ProductReadResponse>{
    
}
