package com.codewithrahhi.todo.controller;

import com.codewithrahhi.todo.dto.TodoDTO;
import com.codewithrahhi.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoDTO> createTodo(
            @RequestBody TodoDTO todoDTO
    ) {
        return ResponseEntity.ok(todoService.createTodo(todoDTO));
    }
}
