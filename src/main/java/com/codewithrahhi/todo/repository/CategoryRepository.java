package com.codewithrahhi.todo.repository;

import com.codewithrahhi.todo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
