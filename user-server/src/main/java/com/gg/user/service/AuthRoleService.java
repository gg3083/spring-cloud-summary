package com.gg.user.service;

import com.gg.user.entity.Role;
import com.gg.user.entity.dto.PageInfo;

/**
 * (AuthRole)表服务接口
 *
 * @author makejava
 * @since 2020-04-22 16:32:16
 */
public interface AuthRoleService {

    Role getById(Long id);

    PageInfo<Role> list(Integer pageNo, Integer pageSize, String searchKey);

    Role save(Role authRole);

    void deleteById(Long id);

}