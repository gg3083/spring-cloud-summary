package com.gg.user.service;

import com.gg.user.entity.Route;
import com.gg.user.entity.dto.PageInfo;

/**
 * (AuthRoute)表服务接口
 *
 * @author makejava
 * @since 2020-04-22 16:32:17
 */
public interface AuthRouteService {

    Route getById(Long id);

    PageInfo<Route> list(Integer pageNo, Integer pageSize, String searchKey);

    Route save(Route route);

    void deleteById(Long id);

}