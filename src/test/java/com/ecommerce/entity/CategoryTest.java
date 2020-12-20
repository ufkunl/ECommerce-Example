package com.ecommerce.entity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CategoryTest {

    private Category category;

    @Before
    public void setup() {
        category = new Category();
        category.setId(1L);
        category.setName("name");
    }

    @Test
    public void hashCodeTest() {
        assertNotNull(category.hashCode());
    }

    @Test
    public void toStringTest() {
        assertNotNull(category.toString());
    }

    @Test
    public void equalsTest() {
        Category instanceToCompare = createCategory();
        Category nullRequest = null;
        Object nullObject = null;
        assertTrue(instanceToCompare.equals(category) && category.equals(instanceToCompare));
        assertNotEquals(category, nullRequest);
        assertNotEquals(category, nullObject);
    }

    private Category createCategory() {
        Category category = new Category();
        category.setId(1L);
        category.setName("name");
        return category;
    }

}
