package com.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @developer -- ufukunal
 */

@Controller
@ApiIgnore
public class HomeController {
    @RequestMapping("/")
    public String home()
    {
        return "redirect:swagger-ui.html";
    }
}
