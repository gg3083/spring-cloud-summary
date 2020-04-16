//package com.gg.backend.controller;
//
//import com.gg.backend.domain.po.JsonBack;
//import com.gg.backend.task.QuartzTaskClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author Gimi
// * @date 2020/4/16 15:49
// */
//@RestController
//@RequestMapping("/task")
//public class TaskJobController {
//
//    @Autowired
//    QuartzTaskClient quartzTaskClient;
//
//    @GetMapping("/list")
//    public JsonBack list(){
//        return new JsonBack(quartzTaskClient.getAllJob());
//    }
//}
