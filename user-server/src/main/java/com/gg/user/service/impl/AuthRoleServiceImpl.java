package com.gg.user.service.impl;

import com.gg.user.entity.Role;
import com.gg.user.dao.AuthRoleDao;
import com.gg.user.service.AuthRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AuthRole)表服务实现类
 *
 * @author makejava
 * @since 2020-04-22 16:32:16
 */
@Service("authRoleService")
public class AuthRoleServiceImpl implements AuthRoleService {
    @Resource
    private AuthRoleDao authRoleDao;


    @Override
    public Role queryById(Integer id) {
        return null;
    }

    @Override
    public List<Role> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public Role insert(Role authRole) {
        return null;
    }

    @Override
    public Role update(Role authRole) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}