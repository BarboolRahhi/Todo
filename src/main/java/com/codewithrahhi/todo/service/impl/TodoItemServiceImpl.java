package com.codewithrahhi.todo.service.impl;

import com.codewithrahhi.todo.dto.TodoDTO;
import com.codewithrahhi.todo.dto.TodoItemDTO;
import com.codewithrahhi.todo.model.Todo;
import com.codewithrahhi.todo.model.TodoItem;
import com.codewithrahhi.todo.repository.TodoItemRepository;
import com.codewithrahhi.todo.repository.TodoRepository;
import com.codewithrahhi.todo.service.Mapper;
import com.codewithrahhi.todo.service.TodoItemService;
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
public class TodoItemServiceImpl implements TodoItemService {

    private final TodoRepository todoRepository;
    private final TodoItemRepository todoItemRepository;
    private final Mapper mapper;

    @Override
    public List<TodoItemDTO> getTodoItemsByTodoId(long todoId) {
        return todoItemRepository.findByTodo_Id(todoId).stream()
                .map(mapper::mapToTodoItemDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<TodoItem> createTodoItems(TodoDTO todoDTO, Todo todo) {
        if (Objects.isNull(todoDTO.getTodoItems())) return Collections.emptyList();
        List<TodoItem> todoItems = todoDTO.getTodoItems().stream()
                .map(todoItemDTO -> {
                    TodoItem todoItem = mapper.mapToTodoItem(todoItemDTO);
                    todoItem.setTodo(todo);
                    return todoItem;
                })
                .collect(Collectors.toList());
        return todoItemRepository.saveAll(todoItems);
    }

    @Override
    public TodoItemDTO createTodoItem(TodoItemDTO todoItemDTO) {
        return todoRepository.findById(todoItemDTO.getId())
                .map(todo -> {
                    TodoItem todoItem = mapper.mapToTodoItem(todoItemDTO);
                    todoItem.setTodo(todo);
                    return mapper.mapToTodoItemDTO(todoItemRepository.save(todoItem));
                })
                .orElseThrow(() -> new RuntimeException("Todo Not Found"));
    }

    @Override
    public TodoItemDTO updateTodoItem(TodoItemDTO todoItemDTO, long todoItemId) {
        return todoItemRepository.findById(todoItemId)
                .map(todoItem -> {
                    todoItem.setTopic(todoItemDTO.getTopic());
                    todoItem.setChecked(todoItemDTO.isChecked());
                    return mapper.mapToTodoItemDTO(todoItemRepository.save(todoItem));
                })
                .orElseThrow(() -> new RuntimeException("TodoItem Not Found"));
    }

    @Override
    public String deleteTodoItem(long todoItemId) {
        return todoItemRepository.findById(todoItemId)
                .map(todoItem -> {
                    todoItemRepository.delete(todoItem);
                    return String.format("TodoItem Deleted successfully with Id: %d", todoItemId);
                })
                .orElseThrow(() -> new RuntimeException("TodoItem Not Found"));
    }
}
