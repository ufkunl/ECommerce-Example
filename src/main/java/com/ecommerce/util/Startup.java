package com.ecommerce.util;

import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.repository.CategoryRepository;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Startup {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Bean("initProduct")
    @DependsOn("initCategory")
    public void initProduct(){
        Product product = new Product();
        product.setCode(ProductUtil.generateProductCode());
        product.setName("Kazak");
        product.setPrice(90.0);
        product.setCategory(categoryRepository.findById(1L).get());
        productRepository.save(product);
    }

    /**
     * initialized when deploy for not empty category list
     * @param
     * @return
     */
    @Bean("initCategory")
    public void initCategory(){
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category("Giyim"));
        categoryList.add(new Category("Ayakkabı"));
        categoryList.add(new Category("Elektronik"));
        categoryList.add(new Category("Spor & Outdoor"));
        categoryRepository.saveAll(categoryList);
    }




}
