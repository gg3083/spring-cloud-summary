package com.gg.backend.controller.auth;

import com.gg.backend.domain.auth.Role;
import com.gg.backend.domain.dto.JsonBack;
import com.gg.backend.domain.dto.PageInfo;
import com.gg.backend.service.AuthRoleService;
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

    @GetMapping("get")
    public Role selectOne(@RequestParam Long id) {
        return this.authRoleService.getById(id);
    }

    @GetMapping("list")
    public JsonBack list(Integer pageNo, Integer pageSize){
        PageInfo<Role> list = authRoleService.list(pageNo, pageSize, null);
        return new JsonBack(list);
    }

    @PutMapping("save")
    public JsonBack save(@RequestBody Role role){
        authRoleService.save(role);
        return new JsonBack(role);
    }

    @DeleteMapping("delete")
    public JsonBack delete(@RequestParam Long id){
        authRoleService.deleteById(id);
        return new JsonBack(id);
    }

}