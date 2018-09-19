package com.example.restservice.api.v1.model.api.v1.mapper;

import com.example.restservice.api.v1.model.CategoryDTO;
import com.example.restservice.domain.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Mapping(source = "id",target = "id")
    CategoryDTO categoryToCategoryDTO(Category category);


}
