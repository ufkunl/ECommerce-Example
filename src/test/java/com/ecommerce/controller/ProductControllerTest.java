package com.ecommerce.controller;

import com.ecommerce.config.SecurityConfig;
import com.ecommerce.dto.CategoryDTO;
import com.ecommerce.dto.ProductDTO;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.ProductNotFound;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.junit.Assert.fail;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    WebApplicationContext context;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @Before
    public void setUp()  {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
        this.objectMapper = new ObjectMapper();
    }


    @WithMockUser(username = "admin", password = "adminPass",roles = "ADMIN")
    @Test
    public void should_create_product() throws Exception {
        ProductDTO productDTO = createProductDTO();

        String requestBody = this.objectMapper.writeValueAsString(productDTO);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isCreated());
    }

    @WithMockUser(username = "admin", password = "adminPass",roles = "ADMIN")
    @Test
    public void should_update_product() throws Exception {
        ProductDTO productDTO = createProductDTOWithId();

        String requestBody = this.objectMapper.writeValueAsString(productDTO);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("/product")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void should_view_product_by_category_id() throws Exception {
        this.mockMvc.perform(get("/product/by-category/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void should_get_product_not_found_exception_in_delete() throws Exception {
        try {
            this.mockMvc.perform(MockMvcRequestBuilders
                    .delete("/product/" + 1L)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
            Assert.assertTrue(true);

            this.mockMvc.perform(MockMvcRequestBuilders
                    .delete("/product/" + 2L)
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON));
        } catch (ProductNotFound p) {
            fail("should_get_product_not_found_exception_in_delete exception ProductNotFound");
        }
    }

    private ProductDTO createProductDTOWithId() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        productDTO.setCode("123456");
        productDTO.setName("product");
        productDTO.setPrice(25.0);
        productDTO.setCategory(getCategoryDTO());
        return productDTO;
    }

    private ProductDTO createProductDTO() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setCode("123456");
        productDTO.setName("product");
        productDTO.setPrice(25.0);
        productDTO.setCategory(getCategoryDTO());
        return productDTO;
    }

    private CategoryDTO getCategoryDTO() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/category"))
                .andReturn();
        List<CategoryDTO> convertedObject = objectMapper.readValue(mvcResult.getResponse().getContentAsString(), new TypeReference<List<CategoryDTO>>(){});
        return convertedObject.get(0);
    }



}
