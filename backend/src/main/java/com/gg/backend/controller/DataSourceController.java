package com.gg.backend.controller;

import com.gg.backend.config.db.RedisClient;
import com.gg.backend.domain.config.DBProperties;
import com.gg.backend.domain.dto.JsonBack;
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

//    @Autowired
//    RedisClient redisClient;

    @Autowired
    RedisClient redisClient;


    @GetMapping("/mysql/list")
    public JsonBack mysqlList(){
//        log.info("{}", dbProperties.getDbConfig());
        return JsonBack.buildSuccJson(dbProperties.getDbConfig());
    }

    @GetMapping("/redis/list")
    public JsonBack redisList(){
//        log.info("{}", redisClient.list());
        return  JsonBack.buildSuccJson(redisClient.list());
    }


}
