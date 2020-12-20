package com.ecommerce.controller;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Product;
import com.ecommerce.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation(value = "lists all category list",
            notes = "",
            responseContainer = "get all category list",
            response = ResponseEntity.class)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProductDTO createProduct(@Valid @RequestBody ProductDTO productDTO){
        return productService.createProduct(productDTO);
    }

    @ApiOperation(value = "lists all category list",
            notes = "",
            responseContainer = "get all category list",
            response = ResponseEntity.class)
    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public ProductDTO updateProduct(@Valid @RequestBody ProductDTO productDTO){
        return productService.updateProduct(productDTO);
    }

    @ApiOperation(value = "lists all category list",
            notes = "",
            responseContainer = "get all category list",
            response = ResponseEntity.class)
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("{productId}")
    public void deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
    }

    @ApiOperation(value = "lists all category list",
            notes = "",
            responseContainer = "get all category list",
            response = ResponseEntity.class)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/by-category/{categoryId}")
    public List<ProductDTO> getProductListByCategory(@PathVariable Long categoryId){
        return productService.getProductListByCategoryId(categoryId);
    }

}
