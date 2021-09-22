package com.codewithrahhi.todo.dto;

import com.codewithrahhi.todo.model.TodoStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class TodoDTO {
    private Long id;
    private String name;
    private String description;
    private TodoStatus todoStatus;
    private LocalDateTime createdAt;
    private LocalDateTime dueAt;
    private List<TodoItemDTO> todoItems;
    private Long categoryId;
}
