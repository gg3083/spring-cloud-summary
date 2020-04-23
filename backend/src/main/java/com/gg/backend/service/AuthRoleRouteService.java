package com.gg.backend.service;


import com.gg.backend.domain.auth.RoleRoute;

import java.util.List;

/**
 * (AuthRoleRoute)表服务接口
 *
 * @author makejava
 * @since 2020-04-22 16:32:17
 */
public interface AuthRoleRouteService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RoleRoute queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<RoleRoute> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param authRoleRoute 实例对象
     * @return 实例对象
     */
    RoleRoute insert(RoleRoute authRoleRoute);

    /**
     * 修改数据
     *
     * @param authRoleRoute 实例对象
     * @return 实例对象
     */
    RoleRoute update(RoleRoute authRoleRoute);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}