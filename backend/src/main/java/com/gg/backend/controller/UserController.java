package com.gg.backend.controller;

import com.alibaba.fastjson.JSONObject;
import com.gg.backend.domain.LoginDTO;
import com.gg.backend.domain.dto.JsonBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

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
    private RestTemplate restTemplate;

    @PostMapping("/user/login")
    public JsonBack login(@RequestBody LoginDTO loginDTO){
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Authorization", "Basic dXNlci1jbGllbnQ6dXNlci1zZWNyZXQtODg4OA==");
        MultiValueMap<String,String> requestBody = new LinkedMultiValueMap();
        requestBody.add("grant_type","password");
        requestBody.add("scope","all");
        requestBody.add("username",loginDTO.getUserName());
        requestBody.add("password",loginDTO.getPassword());
        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<MultiValueMap>(requestBody, requestHeaders);

        ResponseEntity<String> responseEntity  = restTemplate.postForEntity("http://localhost:9002/oauth/token", requestEntity,String.class);

        return new JsonBack(JSONObject.toJSONString(responseEntity.getBody()));

    }


    @PostMapping("user/login2")
    public HashMap login(String username, String password){
        HashMap hashMap = new HashMap();
        hashMap.put("code",0);
        hashMap.put("id",666);
        hashMap.put("realName",username);
        hashMap.put("role","ROLE_ADMIN");
        hashMap.put("token","token");
        return hashMap;

    }

    @GetMapping("user/get")
    public JsonBack get(String username, String password){
        HashMap hashMap = new HashMap();
        hashMap.put("code",0);
        hashMap.put("id",666);
        hashMap.put("realName",username);
        hashMap.put("role","ROLE_ADMIN");
        hashMap.put("token","token");
        return new JsonBack();

    }
}
