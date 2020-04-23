package com.gg.user.controller;

import com.gg.user.entity.UserInfo;
import com.gg.user.entity.dto.JsonBack;
import com.gg.user.entity.dto.PageInfo;
import com.gg.user.service.AuthUserInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (AuthUserInfo)表控制层
 *
 * @author makejava
 * @since 2020-04-22 16:32:17
 */
@RestController
@RequestMapping("authUserInfo")
public class AuthUserInfoController {
    /**
     * 服务对象
     */
    @Resource
    private AuthUserInfoService authUserInfoService;

    @GetMapping("get")
    public UserInfo selectOne(@RequestParam Long id) {
        return this.authUserInfoService.getById(id);
    }

    @GetMapping("list")
    public JsonBack list(Integer pageNo,Integer pageSize){
        PageInfo<UserInfo> list = authUserInfoService.list(pageNo, pageSize, null);
        return new JsonBack(list);
    }

    @PutMapping("save")
    public JsonBack save(@RequestBody UserInfo userInfo){
        authUserInfoService.save(userInfo);
        return new JsonBack(userInfo);
    }

    @DeleteMapping("delete")
    public JsonBack delete(@RequestParam Long id){
        authUserInfoService.deleteById(id);
        return new JsonBack(id);
    }
}