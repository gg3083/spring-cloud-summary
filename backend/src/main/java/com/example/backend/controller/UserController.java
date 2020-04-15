package com.example.backend.controller;

import com.example.backend.domain.User;
import com.example.backend.mapper1.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @Validation对@Valid进行了二次封装，在使用上并没有区别，但在分组、注解位置、嵌套验证等功能上有所不同，这里主要就这几种情况进行说明。
 *
 * 注解位置：
 *
 * @Validated：用在类型、方法和方法参数上。但不能用于成员属性（field）
 *
 * @Valid：可以用在方法、构造函数、方法参数和成员属性（field）上
 * @author GG
 * @date 2019/1/23 19:26
 */
@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @PostMapping("user")
    public String add( String userName,String password){
        userMapper.insert(userName, password);
        return "200";
    }

    @GetMapping("user")
    public ResponseEntity<List<User>> list(){
        return ResponseEntity.ok(userMapper.selectAll());
    }

    @PostMapping("user/login")
    public HashMap login(String username, String password){
        HashMap hashMap = new HashMap();
        hashMap.put("code",0);
        hashMap.put("id",666);
        hashMap.put("realName",username);
        hashMap.put("role","ROLE_ADMIN");
        hashMap.put("token","token");
        return hashMap;

    }
}
