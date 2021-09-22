package com.codewithrahhi.todo.service;

import com.codewithrahhi.todo.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryDTO> getAllCategory();
    CategoryDTO save(CategoryDTO categoryDTO);
    CategoryDTO update(CategoryDTO categoryDTO, long categoryId);
    String delete(long categoryId);
}
