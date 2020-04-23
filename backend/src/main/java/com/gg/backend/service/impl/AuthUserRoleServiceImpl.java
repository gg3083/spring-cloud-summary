package com.gg.backend.service.impl;

import com.gg.backend.dao.AuthUserRoleDao;
import com.gg.backend.domain.auth.UserRole;
import com.gg.backend.domain.dto.UserRoleDTO;
import com.gg.backend.service.AuthUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (AuthUserRole)表服务实现类
 *
 * @author makejava
 * @since 2020-04-22 16:32:17
 */
@Service("authUserRoleService")
public class AuthUserRoleServiceImpl implements AuthUserRoleService {
    @Resource
    private AuthUserRoleDao authUserRoleDao;

    @Override
    public UserRoleDTO getById(Long id) {
        UserRoleDTO dto = this.authUserRoleDao.getDTOById(id);
        return dto;
    }

    @Override
    public UserRoleDTO getByUserId(Long id) {
        UserRoleDTO dto = this.authUserRoleDao.getDTOByUserId(id);
        return dto;
    }

    @Override
    public void save(Long userId, Long roleId) {
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);
        this.authUserRoleDao.save(userRole);
    }
}