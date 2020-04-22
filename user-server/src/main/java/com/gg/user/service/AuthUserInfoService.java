package com.gg.user.service;

import com.gg.user.entity.UserInfo;
import com.gg.user.entity.dto.PageInfo;

/**
 * (AuthUserInfo)表服务接口
 *
 * @author makejava
 * @since 2020-04-22 16:32:17
 */
public interface AuthUserInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserInfo queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param pageNo 查询起始位置
     * @param pageSize 查询条数
     * @return 对象列表
     */
    PageInfo<UserInfo> list(int pageNo, int pageSize, String searchKey);

    /**
     * 新增数据
     *
     * @param authUserInfo 实例对象
     * @return 实例对象
     */
    UserInfo save(UserInfo authUserInfo);

    /**
     * 修改数据
     *
     * @param authUserInfo 实例对象
     * @return 实例对象
     */
    UserInfo update(UserInfo authUserInfo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}