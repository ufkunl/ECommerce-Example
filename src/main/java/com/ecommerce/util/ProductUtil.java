package com.ecommerce.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ProductUtil {


    /**
     * provide unique code for new product
     *
     * @return
     */

    public static String generateProductCode(){
        return RandomStringUtils.randomAlphanumeric(10);
    }

}
