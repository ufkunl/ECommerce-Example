package com.ecommerce.exception;

import com.ecommerce.util.Consts;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @developer -- ufukunal
 */

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = Consts.NO_CATEGORY_FOUND)
public class CategoryNotFound extends Exception{
    static final long serialVersionUID = -3387516993224229948L;

    public CategoryNotFound(String message)
    {
        super(message);
    }

}
