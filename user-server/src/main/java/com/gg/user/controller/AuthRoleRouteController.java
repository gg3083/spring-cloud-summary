package com.gg.user.controller;

import com.gg.user.entity.RoleRoute;
import com.gg.user.service.AuthRoleRouteService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (AuthRoleRoute)表控制层
 *
 * @author makejava
 * @since 2020-04-22 16:32:17
 */
@RestController
@RequestMapping("authRoleRoute")
public class AuthRoleRouteController {
    /**
     * 服务对象
     */
    @Resource
    private AuthRoleRouteService authRoleRouteService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public RoleRoute selectOne(Integer id) {
        return this.authRoleRouteService.queryById(id);
    }

}