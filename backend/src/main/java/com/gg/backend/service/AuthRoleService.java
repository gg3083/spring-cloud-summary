package com.gg.backend.service;


import com.gg.backend.domain.auth.Role;
import com.gg.backend.domain.dto.PageInfo;

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