package com.gg.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Gimi
 * @date 2020/4/9 14:54
 */
@Controller
public class LoginController {

    @GetMapping("redirect")
    public String redirect(){
        return "redirect:/loginPage";
    }
}
