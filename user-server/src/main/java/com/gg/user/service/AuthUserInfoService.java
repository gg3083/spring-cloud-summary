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

    UserInfo getById(Long id);

    PageInfo<UserInfo> list(Integer pageNo, Integer pageSize, String searchKey);

    UserInfo save(UserInfo authUserInfo);

    void deleteById(Long id);

}