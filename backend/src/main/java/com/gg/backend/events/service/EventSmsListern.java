package com.gg.backend.events.service;

import com.gg.backend.events.model.EventBuild;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventSmsListern implements SmartApplicationListener{

    @Override
    public int getOrder() {
        return 1;
    }

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> aClass) {
        return aClass == EventBuild.class;
    }
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        EventBuild event = (EventBuild)applicationEvent;
        event.getUserName().forEach( username->{
            log.info("start sms send user:{} message:{}",username,event.getMessage());
        });
    }
}