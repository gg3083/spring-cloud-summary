package com.example.backend.events.model;

import org.springframework.context.ApplicationEvent;

import java.util.List;

public class EventBuild extends ApplicationEvent {

    private String message;
    private List<String> userName;

    public EventBuild(Object source, String message, List<String> userName) {
        super(source);
        this.message = message;
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getUserName() {
        return userName;
    }

    public void setUserName(List<String> userName) {
        this.userName = userName;
    }
}