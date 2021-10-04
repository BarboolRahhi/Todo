package com.codewithrahhi.todo.controller;

import com.codewithrahhi.todo.dto.CategoryDTO;
import com.codewithrahhi.todo.dto.TodoDTO;
import com.codewithrahhi.todo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(
            @RequestBody CategoryDTO categoryDTO
    ) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryService.createCategory(categoryDTO));
    }

    @PostMapping("/todo")
    public ResponseEntity<TodoDTO> createCategory1(
            @RequestBody TodoDTO todoDTO
    ) {
        System.out.println(todoDTO.toString());
        todoDTO.setId(897L);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(todoDTO);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getCategories() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoryDTO> updateCategory(
            @PathVariable Long id,
            @RequestBody CategoryDTO categoryDTO
    ) {
        return ResponseEntity.ok(categoryService.updateCategory(categoryDTO, id));
    }

}
