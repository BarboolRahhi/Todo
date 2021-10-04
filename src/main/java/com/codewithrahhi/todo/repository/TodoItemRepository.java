package com.codewithrahhi.todo.repository;

import com.codewithrahhi.todo.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}
