package com.gg.user.service;

import com.gg.user.entity.Route;
import java.util.List;

/**
 * (AuthRoute)表服务接口
 *
 * @author makejava
 * @since 2020-04-22 16:32:17
 */
public interface AuthRouteService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Route queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Route> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param authRoute 实例对象
     * @return 实例对象
     */
    Route insert(Route authRoute);

    /**
     * 修改数据
     *
     * @param authRoute 实例对象
     * @return 实例对象
     */
    Route update(Route authRoute);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}