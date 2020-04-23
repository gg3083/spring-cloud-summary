package com.gg.backend.service.impl;

import com.gg.backend.dao.AuthRoleRouteDao;
import com.gg.backend.domain.auth.RoleRoute;
import com.gg.backend.service.AuthRoleRouteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AuthRoleRoute)表服务实现类
 *
 * @author makejava
 * @since 2020-04-22 16:32:17
 */
@Service("authRoleRouteService")
public class AuthRoleRouteServiceImpl implements AuthRoleRouteService {
    @Resource
    private AuthRoleRouteDao authRoleRouteDao;

    @Override
    public RoleRoute queryById(Integer id) {
        return null;
    }

    @Override
    public List<RoleRoute> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public RoleRoute insert(RoleRoute authRoleRoute) {
        return null;
    }

    @Override
    public RoleRoute update(RoleRoute authRoleRoute) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}