package com.ecommerce.service;

import com.ecommerce.dto.CategoryDTO;
import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.mapper.ProductMapper;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.service.impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;


public class ProductServiceTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void should_create_product() {
        when(productMapper.toEntity(Mockito.any())).thenReturn(createProduct());
        when(productRepository.save(Mockito.any())).thenReturn(createProduct());
        when(productMapper.toDTO(createProduct())).thenReturn(createProductDTO());
        Assert.assertNotNull(productService.createProduct(createProductDTO()));
    }

    @Test
    public void should_get_product_by_category() {
        long categoryId = 12345;
        when(productRepository.findByCategoryId(categoryId)).thenReturn(Optional.of(createProductList()));
        when(productMapper.toDTOList(createProductList())).thenReturn(createProductDTOList());
        Assert.assertEquals(createProductDTOList(), productService.getProductListByCategoryId(categoryId));
    }

    @Test
    public void should_get_empty_product_list_by_category() {
        List<Product> emptyList = new ArrayList<>();
        List<ProductDTO> emptyListDTO = new ArrayList<>();
        long categoryId = 12345;
        when(productRepository.findByCategoryId(categoryId)).thenReturn(Optional.of(emptyList));
        when(productMapper.toDTOList(emptyList)).thenReturn(emptyListDTO);
        Assert.assertEquals(emptyListDTO, productService.getProductListByCategoryId(categoryId));
    }

    @Test(expected = EntityNotFoundException.class)
    public void should_get_product_not_found_exception_in_delete() {
        when(productRepository.findById(1L)).thenReturn(Optional.of(createProduct()));
        productService.deleteProduct(1L);
        Assert.assertTrue(true);
        productService.deleteProduct(2L);
    }

    private List<Product> createProductList() {
        List<Product> products = new ArrayList<>();
        products.add(createProduct());
        return products;
    }

    private Product createProduct() {
        Product product = new Product();
        product.setCode("123456");
        product.setName("product");
        product.setPrice(25.0);
        product.setCategory(createCategory());
        return product;
    }

    private Category createCategory() {
        Category category = new Category();
        category.setName("category");
        return category;
    }

    private ProductDTO createProductDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setCode("123456");
        productDTO.setName("product");
        productDTO.setPrice(25.0);
        productDTO.setCategory(createCategoryDTO());
        return productDTO;
    }

    private CategoryDTO createCategoryDTO() {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName("category");
        return categoryDTO;
    }

    private List<ProductDTO> createProductDTOList() {
        List<ProductDTO> productDTOS = new ArrayList<>();
        productDTOS.add(createProductDTO());
        return productDTOS;
    }

}
