package com.ecommerce.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @developer -- ufukunal
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class CategoryDTO extends BaseDTO {

    private String name;

}
