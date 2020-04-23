package com.gg.user.service.impl;

import com.gg.user.dao.AuthRouteDao;
import com.gg.user.entity.Route;
import com.gg.user.entity.dto.PageInfo;
import com.gg.user.service.AuthRouteService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    public Route getById(Long id) {
        return this.authRouteDao.findById(id).orElse(null);
    }

    @Override
    public PageInfo<Route> list(Integer pageNo, Integer pageSize, String searchKey) {
        return new PageInfo<>(this.authRouteDao.findAll(PageInfo.startPage(pageNo,pageSize)));
    }

    @Override
    public Route save(Route route) {
        return this.authRouteDao.save(route);
    }

    @Override
    public void deleteById(Long id) {
        this.authRouteDao.deleteById(id);
    }
}