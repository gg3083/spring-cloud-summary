package com.gg.backend.controller.auth;

import com.gg.backend.service.AuthUserRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @Resource
    private AuthUserRoleService authUserRoleService;


}