package com.gg.user.controller;

import com.gg.user.entity.UserInfo;
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

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserInfo selectOne(Integer id) {
        return this.authUserInfoService.queryById(id);
    }

}