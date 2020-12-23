package com.ecommerce.service.impl;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.ProductNotFound;
import com.ecommerce.mapper.ProductMapper;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProductService;
import com.ecommerce.util.Consts;
import com.ecommerce.util.ProductUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @developer -- ufukunal
 */

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;


    /**
     * Setter injections
     *
     * @param productRepository
     * @param productMapper
     */
    public ProductServiceImpl(ProductRepository productRepository,ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    /**
     * creating product with productDTO
     * @param productDTO
     * @return
     */
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        product.setCode(ProductUtil.generateProductCode());
        product = productRepository.save(product);
        return productMapper.toDTO(product);
    }

    /**
     * updating product with productDTO
     * @param productDTO
     * @throws ProductNotFound
     * @return
     */
    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) throws ProductNotFound {
        Product productFromDb = findProductById(productDTO.getId());
        Product product = productMapper.toEntity(productDTO);
        product.setCode(productFromDb.getCode());
        return productMapper.toDTO(productRepository.save(product));
    }

    /**
     * deleting product with productId
     * @param productId
     * @throws ProductNotFound
     * @return
     */
    @Override
    public void deleteProduct(Long productId) throws ProductNotFound {
        Product productFromDb = findProductById(productId);
        productRepository.delete(productFromDb);
    }

    /**
     * listing product by category id
     * @param categoryId
     * @return
     */
    @Override
    public List<ProductDTO> getProductListByCategoryId(Long categoryId) {
        List<Product> productList = productRepository.findByCategoryId(categoryId)
                .orElse(new ArrayList<>());
        return productMapper.toDTOList(productList);
    }

    private Product findProductById(Long productId) throws ProductNotFound {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFound(Consts.NO_PRODUCT_FOUND));
    }


}
