package com.demo.backend.demoSpringBoot.dao;

import com.demo.backend.demoSpringBoot.model.Task;
import com.demo.backend.demoSpringBoot.model.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskDao extends JpaRepository<Task,Integer> {

 Task findByName(String name);
    List<Task> findByTodoList(TodoList todo);

}
