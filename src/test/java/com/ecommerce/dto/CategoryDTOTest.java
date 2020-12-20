package com.ecommerce.dto;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CategoryDTOTest {

    private CategoryDTO categoryDTO;

    @Before
    public void setup() {
        categoryDTO = new CategoryDTO();
        categoryDTO.setId(1L);
        categoryDTO.setName("name");
    }

    @Test
    public void hashCodeTest() {
        assertNotNull(categoryDTO.hashCode());
    }

    @Test
    public void toStringTest() {
        assertNotNull(categoryDTO.toString());
    }

    @Test
    public void equalsTest() {
        CategoryDTO instanceToCompare = createCategoryDTO();
        CategoryDTO nullRequest = null;
        Object nullObject = null;
        assertTrue(instanceToCompare.equals(categoryDTO) && categoryDTO.equals(instanceToCompare));
        assertNotEquals(categoryDTO, nullRequest);
        assertNotEquals(categoryDTO, nullObject);
    }

    private CategoryDTO createCategoryDTO() {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(1L);
        categoryDTO.setName("name");
        return categoryDTO;
    }

}
