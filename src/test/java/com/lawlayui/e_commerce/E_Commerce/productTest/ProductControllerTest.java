package com.lawlayui.e_commerce.E_Commerce.productTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.security.autoconfigure.SecurityAutoConfiguration;
import org.springframework.boot.security.autoconfigure.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.security.autoconfigure.web.servlet.SecurityFilterAutoConfiguration;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.lawlayui.e_commerce.E_Commerce.api.controller.impl.GlobalExceptionHandler;
import com.lawlayui.e_commerce.E_Commerce.api.controller.impl.ProductControllerImpl;
import com.lawlayui.e_commerce.E_Commerce.custom_exception.ResourceNotFoundException;
import com.lawlayui.e_commerce.E_Commerce.dto.request.product.ProductUpdateRequest;
import com.lawlayui.e_commerce.E_Commerce.dto.response.product.ProductReadResponse;
import com.lawlayui.e_commerce.E_Commerce.service.ProductService;

import tools.jackson.databind.ObjectMapper;

@WebMvcTest(
    controllers = {ProductControllerImpl.class, GlobalExceptionHandler.class},
    excludeAutoConfiguration = {
        SecurityAutoConfiguration.class,
        SecurityFilterAutoConfiguration.class,
        UserDetailsServiceAutoConfiguration.class
    }
)
@AutoConfigureMockMvc(addFilters = false)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private ProductService productService;

    @Test
    void testGetByIdProduct_Success() throws Exception {

        ProductReadResponse mockResponse = ProductReadResponse.builder()
        .id(1L)
        .name("product name")
        .price(BigDecimal.valueOf(12.12))
        .stock(12)
        .build();

        when(productService.getById(1L)).thenReturn(mockResponse);

        mockMvc.perform(get("/api/v1/product/1"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("product name"));

    }

    @Test
    void testGetById_ResouceNotFoundException() throws Exception {

        Long productId = 1L;

        when(productService.getById(productId)).thenThrow(new ResourceNotFoundException("product", 1L));

        mockMvc.perform(get("/api/v1/product/1"))
        .andExpect(status().isNotFound())
        .andExpect(jsonPath("$.message").value("product not found with id 1"));
    }

    @Test
    void testPatchUpdate_ResouceNotFoundException() throws Exception {

        Long productId = 1L;
        ProductUpdateRequest updateRequest = ProductUpdateRequest.builder().build();

        when(productService.update(any(ProductUpdateRequest.class), eq(productId))).thenThrow(new ResourceNotFoundException("product", 1L));

        mockMvc.perform(patch("/api/v1/product/1")
        .contentType(MediaType.APPLICATION_JSON)
        .content(objectMapper.writeValueAsString(updateRequest)))
            .andExpect(status().isNotFound())
            .andExpect(jsonPath("$.message").value("product not found with id 1"));
    }
    @Test
    void testPatchUpdate_ValidationError() throws Exception {
        Long productId = 1L;
    
        ProductUpdateRequest invalidRequest = ProductUpdateRequest.builder()
            .name("on")
            .price(BigDecimal.valueOf(5000))
            .build();

        mockMvc.perform(patch("/api/v1/product/" + productId)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(invalidRequest)))
            .andExpect(status().isBadRequest()) 
            .andExpect(jsonPath("$.message").value("[size must be between 3 and 255]")); 
}
}