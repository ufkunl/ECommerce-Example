package com.ecommerce.dto;

import com.ecommerce.entity.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class ProductDTOTest {

    private ProductDTO productDTO;

    @Before
    public void setup() {
        productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("product");
        productDTO.setPrice(25.0);
        productDTO.setCode("123456789");
    }

    @Test
    public void hashCodeTest() {
        assertNotNull(productDTO.hashCode());
    }

    @Test
    public void toStringTest() {
        assertNotNull(productDTO.toString());
    }

    @Test
    public void equalsTest() {
        ProductDTO instanceToCompare = createProductDTO();
        ProductDTO nullRequest = null;
        Object nullObject = null;
        assertTrue(instanceToCompare.equals(productDTO) && productDTO.equals(instanceToCompare));
        assertNotEquals(productDTO, nullRequest);
        assertNotEquals(productDTO, nullObject);
    }

    private ProductDTO createProductDTO() {
        productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setName("product");
        productDTO.setPrice(25.0);
        productDTO.setCode("123456789");
        return productDTO;
    }

}
