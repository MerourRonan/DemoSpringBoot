package com.demo.backend.demoSpringBoot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private int id;
    @ManyToOne (fetch=FetchType.LAZY)
    @JsonBackReference
    private TodoList todoList;
    @Column
    private String name;
    @Column
    private boolean isDone;

    public Task() {
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

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public TodoList getTodoList() {
        return todoList;
    }

    public void setTodoList(TodoList todoList) {
        this.todoList = todoList;
    }
}
