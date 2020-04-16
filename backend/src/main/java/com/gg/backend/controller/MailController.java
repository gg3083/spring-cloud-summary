package com.gg.backend.controller;

import com.gg.backend.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author GG
 * @date 2018/11/11 22:12
 */
@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    @GetMapping("gmail/{mail}")
    public String send(@PathVariable("mail") String mail){
        mailService.sendByGmail( mail );
        return "success";
    }

    @GetMapping("qq/{mail}")
    public String sendByqq(@PathVariable("mail") String mail){
        mailService.sendByQq( mail );
        return "success";
    }
}
