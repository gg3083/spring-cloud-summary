package com.gg.user.service.impl;

import com.gg.user.entity.Route;
import com.gg.user.dao.AuthRouteDao;
import com.gg.user.service.AuthRouteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (AuthRoute)表服务实现类
 *
 * @author makejava
 * @since 2020-04-22 16:32:17
 */
@Service("authRouteService")
public class AuthRouteServiceImpl implements AuthRouteService {
    @Resource
    private AuthRouteDao authRouteDao;


    @Override
    public Route queryById(Integer id) {
        return null;
    }

    @Override
    public List<Route> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public Route insert(Route authRoute) {
        return null;
    }

    @Override
    public Route update(Route authRoute) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}