package com.codewithrahhi.todo.repository;

import com.codewithrahhi.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
