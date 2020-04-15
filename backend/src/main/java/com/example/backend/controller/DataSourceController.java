package com.example.backend.controller;

import com.example.backend.config.db.RedisClient;
import com.example.backend.domain.config.DBProperties;
import com.example.backend.domain.po.JsonBack;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Gimi
 * @date 2020/4/9 17:19
 */
@RestController
@RequestMapping("/db/")
@Slf4j
@CrossOrigin
public class DataSourceController {

    @Autowired
    DBProperties dbProperties;

    @Autowired
    RedisClient redisClient;


    @GetMapping("/mysql/list")
    public JsonBack mysqlList(){
        log.info("{}", dbProperties.getDbConfig());
        return JsonBack.buildSuccJson(dbProperties.getDbConfig());
    }

    @GetMapping("/redis/list")
    public Object redisList(){
        log.info("{}", redisClient.list());
        return  redisClient.list();
    }


}
