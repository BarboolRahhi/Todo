package com.codewithrahhi.todo.service;

import com.codewithrahhi.todo.dto.CategoryDTO;
import com.codewithrahhi.todo.dto.TodoDTO;
import com.codewithrahhi.todo.dto.TodoItemDTO;
import com.codewithrahhi.todo.model.Category;
import com.codewithrahhi.todo.model.Todo;
import com.codewithrahhi.todo.model.TodoItem;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Mapper {

    private final ModelMapper modelMapper;

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

    public TodoDTO mapToTodoDTO(Todo todo) {
        TodoDTO todoDTO = modelMapper.map(todo, TodoDTO.class);
        todoDTO.setTodoItems(mapToTodoItemDTOList(todo.getTodoItems()));
        return todoDTO;
    }

    public List<TodoItemDTO> mapToTodoItemDTOList(List<TodoItem> todoItems){
       return todoItems
                .stream()
                .map(this::mapToTodoItemDTO)
                .collect(Collectors.toList());
    }

    public TodoItemDTO mapToTodoItemDTO(TodoItem todoItem) {
        return modelMapper.map(todoItem, TodoItemDTO.class);
    }
}
