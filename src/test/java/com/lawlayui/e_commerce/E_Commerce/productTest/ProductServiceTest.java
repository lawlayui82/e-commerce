package com.lawlayui.e_commerce.E_Commerce.productTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.ArgumentCaptor;

import com.lawlayui.e_commerce.E_Commerce.custom_exception.ResourceNotFoundException;
import com.lawlayui.e_commerce.E_Commerce.dto.request.product.ProductUpdateRequest;
import com.lawlayui.e_commerce.E_Commerce.dto.response.BaseResponse;
import com.lawlayui.e_commerce.E_Commerce.entity.Product;
import com.lawlayui.e_commerce.E_Commerce.repository.ProductRepository;
import com.lawlayui.e_commerce.E_Commerce.service.ProductService;
import com.lawlayui.e_commerce.E_Commerce.service.impl.ProductServiceImpl;
import com.lawlayui.e_commerce.E_Commerce.util.mapper.ProductMapper;

public class ProductServiceTest {
    private ProductRepository productRepository;
    private ProductMapper productMapper;
    private ProductService productService;

    @BeforeEach
    void setUp() {
        this.productRepository = mock(ProductRepository.class);
        this.productMapper = Mappers.getMapper(ProductMapper.class);
        this.productService = new ProductServiceImpl(productRepository, productMapper);
    }

    @Test
    void testUpdateStockWithMapper_Success() throws Exception {
        Long productId = 1L;

        ProductUpdateRequest updateStock = ProductUpdateRequest.builder()
        .stock(11)
        .build();

        Product mockProduct = Product.builder()
        .name("product name")
        .stock(12)
        .build();
        
        when(productRepository.findById(productId)).thenReturn(Optional.of(mockProduct));
        when(productRepository.save(any(Product.class))).thenAnswer(invocation -> invocation.getArgument(0));

        ArgumentCaptor<Product> productCaptor = ArgumentCaptor.forClass(Product.class);

        BaseResponse response = productService.update(updateStock, productId);

        verify(productRepository).save(productCaptor.capture());

        Product savedProdcut = productCaptor.getValue();

        assertEquals(11, savedProdcut.getStock());
        assertEquals("product name", savedProdcut.getName());

        assertNotNull(response);
    }

    @Test
    void testUpdate_ResouceNotFoundException () {
        Long productId = 1L;

        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> productService.update(any(ProductUpdateRequest.class), productId));
    }
    
    @Test
    void testFindById_ResouceNotFoundException() {
        Long productId = 1L;

        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> productService.getById(productId));
    }
}
