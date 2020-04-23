package com.gg.backend.dao;

import com.gg.backend.domain.auth.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

/**
 * (AuthUserInfo)表数据库访问层
 *
 * @author makejava
 * @since 2020-04-22 16:32:17
 */
@Resource
public interface AuthUserInfoDao extends JpaRepository<UserInfo,Long> {


}