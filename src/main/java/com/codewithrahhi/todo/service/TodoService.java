package com.codewithrahhi.todo.service;

import com.codewithrahhi.todo.dto.TodoDTO;

import java.util.List;

public interface TodoService {
    List<TodoDTO> getAllTodo();
    TodoDTO createTodo(TodoDTO todoDTO);
    TodoDTO updateTodo(TodoDTO todoDTO, long todoId);
    String deleteTodo(long todoId);
}
