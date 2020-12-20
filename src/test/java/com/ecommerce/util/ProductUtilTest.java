package com.ecommerce.util;

import org.junit.Assert;
import org.junit.Test;

public class ProductUtilTest {

    @Test
    public void should_create_different_codes() {
        String first = ProductUtil.generateProductCode();
        String second = ProductUtil.generateProductCode();
        Assert.assertNotEquals(first, second);
    }

}
