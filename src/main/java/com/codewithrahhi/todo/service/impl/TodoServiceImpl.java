package com.codewithrahhi.todo.service.impl;

import com.codewithrahhi.todo.dto.TodoDTO;
import com.codewithrahhi.todo.repository.TodoRepository;
import com.codewithrahhi.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public List<TodoDTO> getAllTodo() {
        return null;
    }

    @Override
    public TodoDTO createTodo(TodoDTO todoDTO) {
        return null;
    }

    @Override
    public TodoDTO updateTodo(TodoDTO todoDTO, long todoId) {
        return null;
    }

    @Override
    public String deleteTodo(long todoId) {
        return null;
    }
}
