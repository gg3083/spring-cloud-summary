package com.example.backend.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 发送消息类
 * 
 * @author Logan
 * @version 1.0.0
 * @createDate 2019-05-07
 *
 */
@RestController
@RequestMapping("kafka")
@Slf4j
public class SendMessageController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private String topic = "test";

    @GetMapping("/send")
    public String send(String params) {
        log.info("[ 收到请求 ] -- {}",params);
        kafkaTemplate.send(topic, params);
        log.info("[ 已经发送 ] topic：{}，params {}",topic,params);
        return "您的任务已提交";
    }

}