package com.lawlayui.e_commerce.E_Commerce.productTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import com.lawlayui.e_commerce.E_Commerce.entity.Product;
import com.lawlayui.e_commerce.E_Commerce.repository.ProductRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void testGenerationValue_success() {
        Product product = Product.builder()
        .name("a book")
        .price(BigDecimal.valueOf(12.12))
        .stock(12)
        .build(); 

        Product result = productRepository.save(product);

        Product savedProduct = entityManager.find(Product.class, 1L);

        assertNotNull(savedProduct);
        assertNotNull(result);
        assertEquals(savedProduct.getId(), result.getId());
        assertNotNull(result.getCreatedAt());
        assertNotNull(result.getUpdateAt());
    }
}
