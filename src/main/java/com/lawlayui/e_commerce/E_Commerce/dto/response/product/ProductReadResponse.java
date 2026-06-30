package com.lawlayui.e_commerce.E_Commerce.dto.response.product;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.lawlayui.e_commerce.E_Commerce.dto.response.BaseResponse;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ProductReadResponse extends BaseResponse{
    @Builder
    public ProductReadResponse(Long id, LocalDateTime createdAt, LocalDateTime updateAt, String name, BigDecimal price, Integer stock) {
        super(id, createdAt, updateAt);
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    private String name;
    private BigDecimal price;
    private Integer stock;
}
