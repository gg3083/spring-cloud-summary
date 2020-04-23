package com.gg.user.controller;

import com.gg.user.entity.Route;
import com.gg.user.service.AuthRouteService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (AuthRoute)表控制层
 *
 * @author makejava
 * @since 2020-04-22 16:32:17
 */
@RestController
@RequestMapping("authRoute")
public class AuthRouteController {
    /**
     * 服务对象
     */
    @Resource
    private AuthRouteService authRouteService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Route selectOne(Long id) {
        return this.authRouteService.getById(id);
    }

}