package com.ecommerce.service.impl;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Product;
import com.ecommerce.mapper.ProductMapper;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.ProductService;
import com.ecommerce.util.ProductUtil;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository,ProductMapper productMapper,ProductUtil productUtil) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        product.setCode(ProductUtil.generateProductCode());
        product = productRepository.save(product);
        return productMapper.toDTO(product);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        Product productFromDb = productRepository.findById(productDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        Product product = productMapper.toEntity(productDTO);
        product.setCode(productFromDb.getCode());
        return productMapper.toDTO(productRepository.save(product));
    }

    @Override
    public void deleteProduct(Long productId) throws EntityNotFoundException {
        Product productFromDb = productRepository.findById(productId)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        productRepository.delete(productFromDb);
    }

    @Override
    public List<ProductDTO> getProductListByCategoryId(Long categoryId) {
        List<Product> productList = productRepository.findByCategoryId(categoryId)
                .orElse(new ArrayList<>());
        return productMapper.toDTOList(productList);
    }


}
