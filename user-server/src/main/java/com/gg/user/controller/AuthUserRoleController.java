package com.gg.user.controller;

import com.gg.user.entity.UserRole;
import com.gg.user.service.AuthUserRoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (AuthUserRole)表控制层
 *
 * @author makejava
 * @since 2020-04-22 16:32:17
 */
@RestController
@RequestMapping("authUserRole")
public class AuthUserRoleController {
    /**
     * 服务对象
     */
    @Resource
    private AuthUserRoleService authUserRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public UserRole selectOne(Integer id) {
        return this.authUserRoleService.queryById(id);
    }

}