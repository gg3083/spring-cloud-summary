package com.gg.user.controller;

import com.gg.user.entity.UserInfo;
import com.gg.user.entity.dto.JsonBack;
import com.gg.user.entity.dto.PageInfo;
import com.gg.user.entity.dto.UserInfoDTO;
import com.gg.user.service.AuthUserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value="用户操作类",tags={"用户操作接口"})
public class AuthUserInfoController {
    /**
     * 服务对象
     */
    @Resource
    private AuthUserInfoService authUserInfoService;

    @GetMapping("get")
    @ApiOperation(value = "用户信息查询")
    public JsonBack get(@RequestParam Long id) {
        return new JsonBack(this.authUserInfoService.getById(id));
    }

    @GetMapping("getInfo")
    @ApiOperation(value = "用户信息查询")
    public JsonBack getInfo(@RequestParam Long id) {
        return new JsonBack(this.authUserInfoService.getDTOById(id));
    }

    @GetMapping("list")
    @ApiOperation(value = "用户列表查询")
    public JsonBack list(Integer pageNo,Integer pageSize){
        PageInfo<UserInfo> list = authUserInfoService.list(pageNo, pageSize, null);
        return new JsonBack(list);
    }

    @PutMapping("save")
    @ApiOperation(value = "用户保存或修改")
    public JsonBack save(@RequestBody UserInfoDTO userInfoDTO){
        authUserInfoService.save(userInfoDTO);
        return new JsonBack(userInfoDTO);
    }

    @DeleteMapping("delete")
    @ApiOperation(value = "用户删除")
    public JsonBack delete(@RequestParam Long id){
        authUserInfoService.deleteById(id);
        return new JsonBack(id);
    }

    @PutMapping("set-role")
    @ApiOperation(value = "设置权限")
    public JsonBack setRole(@RequestParam Long userId,@RequestParam Long roleId){
        authUserInfoService.setRole(userId, roleId);
        return new JsonBack();
    }

}