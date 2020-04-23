package com.gg.backend.dao;

import com.gg.backend.domain.auth.RoleRoute;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

/**
 * (AuthRoleRoute)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-22 16:32:17
 */
@Resource
public interface AuthRoleRouteDao extends JpaRepository<RoleRoute,Long> {


}