package com.ecommerce.dto;


import lombok.Data;
import lombok.EqualsAndHashCode;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @developer -- ufukunal
 */

@EqualsAndHashCode(callSuper = true)
@Data
public class ProductDTO extends BaseDTO {

    private String name;

    private double price;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String code;

    private CategoryDTO category;

}
