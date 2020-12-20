package com.ecommerce.service;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Product;
import javassist.NotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public interface ProductService {

    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO updateProduct(ProductDTO productDTO);

    void deleteProduct(Long productId) throws EntityNotFoundException;

    List<ProductDTO> getProductListByCategoryId(Long categoryId);

}
