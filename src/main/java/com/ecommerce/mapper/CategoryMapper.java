package com.ecommerce.mapper;

import com.ecommerce.dto.CategoryDTO;
import com.ecommerce.entity.Category;
import org.mapstruct.Mapper;

/**
 * @developer -- ufukunal
 */

@Mapper(componentModel = "spring")
public interface CategoryMapper extends BaseMapper<Category, CategoryDTO> {
}
