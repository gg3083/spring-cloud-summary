package com.gg.user.dao;

import com.gg.user.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

/**
 * (AuthUserRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-22 16:32:17
 */
@Resource
public interface AuthUserRoleDao extends JpaRepository<UserRole, Long> {



}