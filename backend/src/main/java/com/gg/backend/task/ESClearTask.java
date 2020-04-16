package com.gg.backend.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Gimi
 * @date 2020/3/9 11:28
 */
@Configuration
@EnableScheduling
@Slf4j
public class ESClearTask {

    @Scheduled(cron = "0 0/10 * * * ? ")
    private void configureTasks() {
        log.info("start Scheduled");
    }
}
