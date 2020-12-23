package com.ecommerce.service;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.exception.ProductNotFound;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * @developer -- ufukunal
 */

public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO updateProduct(ProductDTO productDTO) throws EntityNotFoundException, ProductNotFound;

    void deleteProduct(Long productId) throws EntityNotFoundException, ProductNotFound;

    List<ProductDTO> getProductListByCategoryId(Long categoryId);

}
