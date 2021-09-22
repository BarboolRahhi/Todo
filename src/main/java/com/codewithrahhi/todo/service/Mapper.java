package com.codewithrahhi.todo.service;

import com.codewithrahhi.todo.dto.CategoryDTO;
import com.codewithrahhi.todo.model.Category;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public CategoryDTO mapToCategoryDTO(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .description(category.getDescription())
                .name(category.getName())
                .build();
    }

    public Category mapToCategory(CategoryDTO categoryDTO) {
        return Category.builder()
                .description(categoryDTO.getDescription())
                .name(categoryDTO.getName())
                .build();
    }
}
