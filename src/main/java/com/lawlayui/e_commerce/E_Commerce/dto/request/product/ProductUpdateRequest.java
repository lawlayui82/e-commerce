package com.lawlayui.e_commerce.E_Commerce.dto.request.product;

import java.math.BigDecimal;

import com.lawlayui.e_commerce.E_Commerce.dto.request.BaseRequest;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductUpdateRequest extends BaseRequest{
    
    @Size(max = 255, min = 3)
    private String name;

    @DecimalMin(value = "0.0")
    private BigDecimal price;

    @Min(value = 0)
    private Integer stock;
}
