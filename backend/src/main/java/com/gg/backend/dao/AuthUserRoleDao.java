package com.gg.backend.dao;

import com.gg.backend.domain.auth.UserRole;
import com.gg.backend.domain.dto.UserRoleDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.annotation.Resource;

/**
 * (AuthUserRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-22 16:32:17
 */
@Resource
public interface AuthUserRoleDao extends JpaRepository<UserRole, Long> {

    @Query(value = "SELECT new  com.gg.backend.domain.dto.UserRoleDTO(u, r) FROM UserRole ur,UserInfo u,Role r " +
            "where  ur.userId = u.id and ur.roleId = r.id and ur.id = :id")
    UserRoleDTO getDTOById(@Param("id") Long id);

    @Query(value = "SELECT new com.gg.backend.domain.dto.UserRoleDTO(u, r) FROM UserRole ur,UserInfo u,Role r " +
            "where  ur.userId = u.id and ur.roleId = r.id and ur.userId = :userId")
    UserRoleDTO getDTOByUserId(@Param("userId") Long userId);

}