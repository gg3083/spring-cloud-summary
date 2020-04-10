package com.example.backend.controller;

import com.example.backend.events.controller.EventPublish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gimi
 * @date 2020/4/10 10:26
 */
@RestController
public class MessagePushController {

    @Autowired
    EventPublish publish;

    @GetMapping("send")
    public String send(String message){
        List<String> userNames = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            userNames.add( i + "");
        }
        publish.publish(message, userNames);
        return message;
    }
}
