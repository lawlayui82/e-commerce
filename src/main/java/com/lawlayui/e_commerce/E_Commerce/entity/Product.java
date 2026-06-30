package com.lawlayui.e_commerce.E_Commerce.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product extends BaseEntity{
    @Builder
    public Product(Long id, LocalDateTime createdAt, LocalDateTime updateAt, String name, BigDecimal price, Integer stock) {
        super(id, createdAt, updateAt);
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer stock;
}
