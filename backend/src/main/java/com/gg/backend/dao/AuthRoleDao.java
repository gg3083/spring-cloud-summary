package com.gg.backend.dao;


import com.gg.backend.domain.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

/**
 * (AuthRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-22 16:32:16
 */
@Resource
public interface AuthRoleDao extends JpaRepository<Role,Long> {


}