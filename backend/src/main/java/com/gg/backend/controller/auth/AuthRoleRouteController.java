package com.gg.backend.controller.auth;

import com.gg.backend.domain.auth.RoleRoute;
import com.gg.backend.service.AuthRoleRouteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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