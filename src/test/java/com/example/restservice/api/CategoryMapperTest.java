package com.example.restservice.api;

import com.example.restservice.api.v1.model.CategoryDTO;
import com.example.restservice.api.v1.model.api.v1.mapper.CategoryMapper;
import com.example.restservice.domain.Category;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CategoryMapperTest {

    CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    @Test
    public void categoryToCategoryDTO() throws Exception{

        Category category = new Category();
        category.setName("Joe");
        category.setId(1L);

        CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

        assertEquals(Long.valueOf(1L),categoryDTO.getId());
        assertEquals("Joe",categoryDTO.getName());
    }
}
