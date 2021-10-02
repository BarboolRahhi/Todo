package com.codewithrahhi.todo.service.impl;

import com.codewithrahhi.todo.dto.CategoryDTO;
import com.codewithrahhi.todo.model.Category;
import com.codewithrahhi.todo.repository.CategoryRepository;
import com.codewithrahhi.todo.service.CategoryService;
import com.codewithrahhi.todo.service.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final Mapper mapper;

    @Override
    public List<CategoryDTO> getAllCategory() {
        return categoryRepository.findAll().stream()
                .map(mapper::mapToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = categoryRepository.save(mapper.mapToCategory(categoryDTO));
        return mapper.mapToCategoryDTO(category);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, long categoryId) {
        return categoryRepository.findById(categoryId)
                .map(category -> {
                    category.setDescription(categoryDTO.getDescription());
                    category.setName(categoryDTO.getName());
                    return mapper.mapToCategoryDTO(categoryRepository.save(category));
                })
                .orElseThrow(() -> new RuntimeException("Category No Found"));
    }

    @Override
    public String deleteCategory(long categoryId) {
        return categoryRepository.findById(categoryId)
                .map(category -> {
                    categoryRepository.delete(category);
                    return String.format("Category Deleted successfully with Id: %d", categoryId);
                })
                .orElseThrow(() -> new RuntimeException("Category No Found"));
    }
}
