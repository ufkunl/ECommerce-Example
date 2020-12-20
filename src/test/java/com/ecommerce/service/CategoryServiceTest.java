package com.ecommerce.service;

import com.ecommerce.dto.CategoryDTO;
import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.mapper.CategoryMapper;
import com.ecommerce.repository.CategoryRepository;
import com.ecommerce.service.impl.CategoryServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class CategoryServiceTest {

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private CategoryMapper categoryMapper;

    @Test
    public void should_get_empty_category_list() {
        List<Category> emptyList = new ArrayList<>();
        List<CategoryDTO> emptyListDTO = new ArrayList<>();

        when(categoryRepository.findAll()).thenReturn(emptyList);
        when(categoryMapper.toDTOList(emptyList)).thenReturn(emptyListDTO);

        Assert.assertEquals(emptyListDTO, categoryService.getCategoryList());
    }



    private Category createCategory(){
        Category category = new Category();
        category.setName("category");
        return category;
    }

    private CategoryDTO createCategoryDTO(){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setName("category");
        return categoryDTO;
    }

    private List<Category> createCategoryList(){
        List<Category> list = new ArrayList<>();
        list.add(createCategory());
        return list;
    }

    private List<CategoryDTO> createCategoryDTOList(){
        List<CategoryDTO> listDTO = new ArrayList<>();
        listDTO.add(createCategoryDTO());
        return listDTO;
    }

}
