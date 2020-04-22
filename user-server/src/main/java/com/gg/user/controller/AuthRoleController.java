package com.gg.user.controller;

import com.gg.user.entity.Role;
import com.gg.user.service.AuthRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (AuthRole)表控制层
 *
 * @author makejava
 * @since 2020-04-22 16:32:16
 */
@RestController
@RequestMapping("authRole")
public class AuthRoleController {
    /**
     * 服务对象
     */
    @Resource
    private AuthRoleService authRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Role selectOne(Integer id) {
        return this.authRoleService.queryById(id);
    }

}