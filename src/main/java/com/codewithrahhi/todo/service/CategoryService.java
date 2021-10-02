package com.codewithrahhi.todo.service;

import com.codewithrahhi.todo.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategory();
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO updateCategory(CategoryDTO categoryDTO, long categoryId);
    String deleteCategory(long categoryId);
}
