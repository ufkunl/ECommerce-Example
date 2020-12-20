package com.ecommerce.entity;

import com.ecommerce.dto.ProductDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class ProductTest {

    private Product product;

    @Before
    public void setup() {
        product = new Product();
        product.setId(1L);
        product.setName("product");
        product.setPrice(25.0);
        product.setCode("123456789");
    }

    @Test
    public void hashCodeTest() {
        assertNotNull(product.hashCode());
    }

    @Test
    public void toStringTest() {
        assertNotNull(product.toString());
    }

    @Test
    public void equalsTest() {
        Product instanceToCompare = createProduct();
        Product nullRequest = null;
        Object nullObject = null;
        assertTrue(instanceToCompare.equals(product) && product.equals(instanceToCompare));
        assertNotEquals(product, nullRequest);
        assertNotEquals(product, nullObject);
    }

    private Product createProduct() {
        product = new Product();
        product.setId(1L);
        product.setName("product");
        product.setPrice(25.0);
        product.setCode("123456789");
        return product;
    }

}
