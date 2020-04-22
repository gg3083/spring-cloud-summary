package com.gg.user.service.impl;

import com.gg.user.entity.UserRole;
import com.gg.user.dao.AuthUserRoleDao;
import com.gg.user.service.AuthUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public UserRole queryById(Integer id) {
        return null;
    }

    @Override
    public List<UserRole> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public UserRole insert(UserRole authUserRole) {
        return null;
    }

    @Override
    public UserRole update(UserRole authUserRole) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}