package com.lawlayui.e_commerce.E_Commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lawlayui.e_commerce.E_Commerce.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
       
}

