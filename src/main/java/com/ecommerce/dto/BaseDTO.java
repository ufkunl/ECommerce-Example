package com.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @developer -- ufukunal
 */

@EqualsAndHashCode(of = "id")
@Data
public abstract class BaseDTO implements Serializable {

    private Long id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime creationDate = LocalDateTime.now();

}
