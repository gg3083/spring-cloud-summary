package com.example.backend.events.controller;

import com.example.backend.events.model.EventBuild;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Max;
import java.util.List;

/**
 * @author Gimi
 * @date 2020/4/10 10:24
 */
@Component
public class EventPublish {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * @Async 开启异步执行
     * @param message
     * @param userName
     */
    @Async
    public void publish(String message, List<String> userName){
        EventBuild build = new EventBuild(this, message, userName);
        applicationEventPublisher.publishEvent(build);
    }

}