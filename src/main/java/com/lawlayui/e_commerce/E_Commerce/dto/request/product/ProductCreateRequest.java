package com.lawlayui.e_commerce.E_Commerce.dto.request.product;

import java.math.BigDecimal;

import com.lawlayui.e_commerce.E_Commerce.dto.request.BaseRequest;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCreateRequest extends BaseRequest{
    @NotBlank
    @Size(max = 255, min = 3)
    private String name;

    @NotNull
    @DecimalMin(value = "0.0")
    private BigDecimal price;

    @NotNull
    @Min(value = 0)
    private Integer stock;
}
