package com.codewithrahhi.todo.service;

import com.codewithrahhi.todo.dto.TodoDTO;
import com.codewithrahhi.todo.dto.TodoItemDTO;
import com.codewithrahhi.todo.model.Todo;
import com.codewithrahhi.todo.model.TodoItem;

import java.util.List;

public interface TodoItemService {
    List<TodoItemDTO> getTodoItemsByTodoId(long todoId);
    List<TodoItem> createTodoItems(TodoDTO todoDTO, Todo todo);
    TodoItemDTO createTodoItem(TodoItemDTO todoItemDTO);
    TodoItemDTO updateTodoItem(TodoItemDTO todoItemDTO, long todoItemId);
    String deleteTodoItem(long todoItemId);
}
