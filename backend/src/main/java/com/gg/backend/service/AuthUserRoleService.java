package com.gg.backend.service;


import com.gg.backend.domain.dto.UserRoleDTO;

/**
 * (AuthUserRole)表服务接口
 *
 * @author makejava
 * @since 2020-04-22 16:32:17
 */
public interface AuthUserRoleService {

    UserRoleDTO getById(Long id);

    UserRoleDTO getByUserId(Long id);

    void save(Long userId, Long roleId);
}