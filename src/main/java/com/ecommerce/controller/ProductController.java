package com.ecommerce.controller;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.exception.ProductNotFound;
import com.ecommerce.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @developer -- ufukunal
 */

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Endpoint that creating a product
     *
     * @param productDTO
     * @return
     */
    @ApiOperation(value = "creating product",
            notes = "",
            responseContainer = "create product",
            response = ResponseEntity.class)
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ProductDTO createProduct(@Valid @RequestBody ProductDTO productDTO){
        return productService.createProduct(productDTO);
    }

    /**
     * Endpoint that updating a product
     *
     * @param productDTO
     * @return
     * @throws ProductNotFound
     *
     */
    @ApiOperation(value = "updating product by id",
            notes = "",
            responseContainer = "update a product",
            response = ResponseEntity.class)
    @ResponseStatus(HttpStatus.OK)
    @PutMapping
    public ProductDTO updateProduct(@Valid @RequestBody ProductDTO productDTO) throws ProductNotFound {
        return productService.updateProduct(productDTO);
    }

    /**
     * Endpoint that deleting a product
     *
     * @param productId
     * @return
     * @throws ProductNotFound
     *
     */
    @ApiOperation(value = "deleting product by id",
            notes = "",
            responseContainer = "delete a product",
            response = ResponseEntity.class)
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId) throws ProductNotFound {
        productService.deleteProduct(productId);
    }

    /**
     * Endpoint that listing product list by category
     *
     * @param categoryId
     * @return
     * @throws
     *
     */
    @ApiOperation(value = "listing product list by category",
            notes = "",
            responseContainer = "list products",
            response = ResponseEntity.class)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/by-category/{categoryId}")
    public List<ProductDTO> getProductListByCategory(@PathVariable Long categoryId){
        return productService.getProductListByCategoryId(categoryId);
    }

}
