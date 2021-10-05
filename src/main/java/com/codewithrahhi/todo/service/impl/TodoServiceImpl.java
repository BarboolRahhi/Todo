package com.codewithrahhi.todo.service.impl;

import com.codewithrahhi.todo.dto.TodoDTO;
import com.codewithrahhi.todo.model.Todo;
import com.codewithrahhi.todo.model.TodoItem;
import com.codewithrahhi.todo.repository.CategoryRepository;
import com.codewithrahhi.todo.repository.TodoItemRepository;
import com.codewithrahhi.todo.repository.TodoRepository;
import com.codewithrahhi.todo.service.Mapper;
import com.codewithrahhi.todo.service.TodoItemService;
import com.codewithrahhi.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final CategoryRepository categoryRepository;
    private final TodoItemService todoItemService;
    private final Mapper mapper;

    @Override
    public List<TodoDTO> getAllTodo() {
        return todoRepository.findAll().stream()
                .map(mapper::mapToTodoDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TodoDTO createTodo(TodoDTO todoDTO) {
        return categoryRepository.findById(todoDTO.getCategoryId())
                .map(category -> {
                    Todo todo = mapper.mapToTodo(todoDTO);
                    todo.setCategory(category);
                    Todo savedTodo = todoRepository.save(todo);
                    List<TodoItem> items = todoItemService.createTodoItems(todoDTO, todo);
                    todo.setTodoItems(items);
                    return mapper.mapToTodoDTO(savedTodo);
                }).orElseThrow(() -> new RuntimeException("Category Not Found"));
    }



    @Override
    public TodoDTO updateTodo(TodoDTO todoDTO, long todoId) {
        return todoRepository.findById(todoId)
                .map(todo -> {
                    todo.setName(todoDTO.getName());
                    todo.setTodoStatus(todoDTO.getTodoStatus());
                    todo.setDescription(todoDTO.getDescription());
                    todo.setDueAt(todoDTO.getDueAt());
                    return mapper.mapToTodoDTO(todoRepository.save(todo));
                }).orElseThrow(() -> new RuntimeException("Todo Not Found"));
    }

    @Override
    public String deleteTodo(long todoId) {
        return todoRepository.findById(todoId)
                .map(todo -> {
                    todoRepository.delete(todo);
                    return String.format("Todo Deleted successfully with Id: %d", todoId);
                }).orElseThrow(() -> new RuntimeException("Todo Not Found"));
    }
}
