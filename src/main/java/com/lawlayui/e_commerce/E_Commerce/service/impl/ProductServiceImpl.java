package com.lawlayui.e_commerce.E_Commerce.service.impl;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.lawlayui.e_commerce.E_Commerce.custom_exception.ResourceNotFoundException;
import com.lawlayui.e_commerce.E_Commerce.dto.request.product.ProductCreateRequest;
import com.lawlayui.e_commerce.E_Commerce.dto.request.product.ProductUpdateRequest;
import com.lawlayui.e_commerce.E_Commerce.dto.response.BaseResponse;
import com.lawlayui.e_commerce.E_Commerce.dto.response.product.ProductReadResponse;
import com.lawlayui.e_commerce.E_Commerce.entity.Product;
import com.lawlayui.e_commerce.E_Commerce.repository.ProductRepository;
import com.lawlayui.e_commerce.E_Commerce.service.ProductService;
import com.lawlayui.e_commerce.E_Commerce.util.mapper.ProductMapper;

public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;
    private ProductMapper productMapper; 

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public BaseResponse create(ProductCreateRequest createRequest) {
        Product product = productRepository.save(productMapper.requestToEntity(createRequest)); 

        return new BaseResponse(product.getId(), product.getCreatedAt(), product.getUpdateAt());
    }

    @Override
    public List<ProductReadResponse> getAll(Pageable pageable) {
        return productMapper.entityToResponses(productRepository.findAll(pageable).getContent());
    }

    @Override
    public ProductReadResponse getById(Long id) throws ResourceNotFoundException {
        return productMapper.entityToResponse(productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product", id)));
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public BaseResponse update(ProductUpdateRequest updateRequest, Long id) throws ResourceNotFoundException {
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("product", id));
        productMapper.updateEntityFromDto(updateRequest, product);
        productRepository.save(product);
        return new BaseResponse(product.getId(), product.getCreatedAt(), product.getUpdateAt());
    }
    
}
