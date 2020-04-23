package com.gg.user.service.impl;

import com.gg.user.dao.AuthRoleDao;
import com.gg.user.entity.Role;
import com.gg.user.entity.dto.PageInfo;
import com.gg.user.service.AuthRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    public Role getById(Long id) {
        return authRoleDao.findById(id).orElse(null);
    }

    @Override
    public PageInfo<Role> list(Integer pageNo, Integer pageSize, String searchKey) {
        return new PageInfo<>(authRoleDao.findAll(PageInfo.startPage(pageNo, pageSize)));
    }

    @Override
    public Role save(Role authRole) {
        return this.authRoleDao.save(authRole);
    }

    @Override
    public void deleteById(Long id) {
        this.authRoleDao.deleteById(id);
    }
}