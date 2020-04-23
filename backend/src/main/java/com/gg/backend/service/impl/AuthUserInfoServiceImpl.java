package com.gg.backend.service.impl;

import com.gg.backend.dao.AuthUserInfoDao;
import com.gg.backend.domain.auth.Role;
import com.gg.backend.domain.auth.UserInfo;
import com.gg.backend.domain.dto.PageInfo;
import com.gg.backend.domain.dto.UserInfoDTO;
import com.gg.backend.domain.dto.UserRoleDTO;
import com.gg.backend.exception.CustomException;
import com.gg.backend.service.AuthRoleService;
import com.gg.backend.service.AuthUserInfoService;
import com.gg.backend.service.AuthUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (AuthUserInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-04-22 16:32:17
 */
@Service("authUserInfoService")
public class AuthUserInfoServiceImpl implements AuthUserInfoService {
    @Resource
    private AuthUserInfoDao authUserInfoDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthUserRoleService authUserRoleService;

    @Autowired
    private AuthRoleService authRoleService;

    @Override
    public UserInfo getById(Long id) {
        return authUserInfoDao.findById(id).orElse(null);
    }

    @Override
    public UserInfoDTO getDTOById(Long id) {
        UserInfo userInfo = getById(id);
        if (userInfo == null) {
            throw new CustomException("用户不存在");
        }
        UserRoleDTO userRoleDTO = authUserRoleService.getByUserId(id);
        if (userRoleDTO == null ){
            throw new CustomException("查询角色失败");
        }
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setUserInfo(userRoleDTO.getUserInfo());
        userInfoDTO.setRoleName(userRoleDTO.getRole().getRoleName());
        userInfoDTO.setRoleDesc(userRoleDTO.getRole().getRoleDesc());
        userInfoDTO.setRoutes(null);
        return userInfoDTO;
    }

    @Override
    public PageInfo<UserInfo> list(Integer pageNo, Integer pageSize, String searchKey) {
        Page<UserInfo> all = authUserInfoDao.findAll(PageInfo.startPage(pageNo,pageSize));
        return new PageInfo<>(all);
    }

    @Override
    public UserInfoDTO save(UserInfoDTO userInfoDTO) {
        UserInfo userInfo = userInfoDTO.getUserInfo();
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        authUserInfoDao.save(userInfo);
        //TODO 设置默认权限
        return userInfoDTO;
    }

    @Override
    public void deleteById(Long id) {
        authUserInfoDao.deleteById(id);
    }

    @Override
    public void setRole(Long userId, Long roleId) {
        UserInfo userInfo = getById(userId);
        if (userInfo == null){
            throw new CustomException("用户不存在");
        }
        Role role = authRoleService.getById(roleId);
        if (role == null){
            throw new CustomException("权限不存在");
        }
        authUserRoleService.save(userId, roleId);
    }
}