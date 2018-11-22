package com.demo.backend.demoSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TodoList {

    @Id
    @GeneratedValue
    private int id;
    @Column
    private int userId;
    @Column
    private String name;
    @OneToMany(fetch=FetchType.LAZY,mappedBy="todoList")
    @JsonManagedReference
    private List<Task> tasks;

    public TodoList() {
        tasks = new ArrayList<Task>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        tasks = tasks;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void addTask(Task newTask)
    {
        tasks.add(newTask);
    }
}
