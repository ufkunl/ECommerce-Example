package com.ecommerce.mapper;

import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Product;
import org.mapstruct.Mapper;

/**
 * @developer -- ufukunal
 */

@Mapper(componentModel = "spring",uses = CategoryMapper.class)
public interface ProductMapper extends BaseMapper<Product, ProductDTO> {
}
