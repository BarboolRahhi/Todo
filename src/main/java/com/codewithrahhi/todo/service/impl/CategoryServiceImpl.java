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
    public CategoryDTO save(CategoryDTO categoryDTO) {
        Category category = categoryRepository.save(mapper.mapToCategory(categoryDTO));
        return mapper.mapToCategoryDTO(category);
    }

    @Override
    public CategoryDTO update(CategoryDTO categoryDTO, long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category No Found"));
        category.setDescription(categoryDTO.getDescription());
        category.setName(categoryDTO.getName());
        categoryRepository.save(category);
        return mapper.mapToCategoryDTO(category);
    }

    @Override
    public String delete(long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new RuntimeException("Category No Found"));
        categoryRepository.delete(category);
        return String.format("Category Deleted successfully with Id: %d", categoryId);
    }
}
