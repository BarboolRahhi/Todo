package com.codewithrahhi.todo.repository;

import com.codewithrahhi.todo.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    List<TodoItem> findByTodo_Id(long todoId);
}
