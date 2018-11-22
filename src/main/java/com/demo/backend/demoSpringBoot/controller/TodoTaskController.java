package com.demo.backend.demoSpringBoot.controller;

import com.demo.backend.demoSpringBoot.dao.TaskDao;
import com.demo.backend.demoSpringBoot.dao.TodoListDao;
import com.demo.backend.demoSpringBoot.model.TodoList;
import com.demo.backend.demoSpringBoot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class TodoTaskController {

    @Autowired
    private TodoListDao todoListDao;
    @Autowired
    private TaskDao taskDao;


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value="/api/user{userId}/allTodos")
    public ResponseEntity<List<TodoList>> getAlltodosAndTasks(@PathVariable int userId)
    {
        System.out.print("\u001B[34m "+"TodoTaskController : getAlltodosAndTasks" + "\n "+"\u001B[0m");
        List<TodoList> todos = todoListDao.findByUserId(userId);
        return new ResponseEntity<List<TodoList>>(todos,HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value="/api/updateTodo")
    public ResponseEntity<Void> updateTodo(@RequestBody TodoList todo)
    {
        System.out.print("\u001B[34m "+"TodoTaskController : updateTodo" + "\n "+"\u001B[0m");
        TodoList todos = todoListDao.save(todo);
        if(todos==null) {
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        else {
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
    }
}
