package com.gov.dwp.heroku.model;

import java.util.ArrayList;

import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {

    private ArrayList<UserId> users;

    public ArrayList<UserId> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<UserId> users) {
        this.users = users;
    }
    
}
