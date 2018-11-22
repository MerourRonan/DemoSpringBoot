package com.demo.backend.demoSpringBoot.dao;

import com.demo.backend.demoSpringBoot.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoListDao extends JpaRepository<TodoList,Integer> {

 TodoList findByName(String name);
 List<TodoList> findByUserId(int userId);
 TodoList save(TodoList todo);
}
