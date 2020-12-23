package com.ecommerce.controller;

import com.ecommerce.dto.CategoryDTO;
import com.ecommerce.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @developer -- ufukunal
 */

@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(@Qualifier("categoryServiceImpl") CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @ApiOperation(value = "listing all category list",
            notes = "",
            responseContainer = "list categories",
            response = ResponseEntity.class)
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<CategoryDTO> getCategoryList(){
        return categoryService.getCategoryList();
    }

}
