package com.test.heroku.model;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Instruction {

    private String todo;

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }
}
