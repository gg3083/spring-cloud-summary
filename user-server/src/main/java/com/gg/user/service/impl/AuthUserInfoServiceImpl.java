package com.gg.user.service.impl;

import com.gg.user.dao.AuthUserInfoDao;
import com.gg.user.entity.UserInfo;
import com.gg.user.entity.dto.PageInfo;
import com.gg.user.service.AuthUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (AuthUserInfo)表服务实现类
 *
 * @author makejava
 * @since 2020-04-22 16:32:17
 */
@Service("authUserInfoService")
public class AuthUserInfoServiceImpl implements AuthUserInfoService {
    @Resource
    private AuthUserInfoDao authUserInfoDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserInfo getById(Long id) {
        return authUserInfoDao.findById(id).orElse(null);
    }

    @Override
    public PageInfo<UserInfo> list(Integer pageNo, Integer pageSize, String searchKey) {
        Page<UserInfo> all = authUserInfoDao.findAll(PageInfo.startPage(pageNo,pageSize));
        return new PageInfo<>(all);
    }

    @Override
    public UserInfo save(UserInfo authUserInfo) {
        authUserInfo.setPassword(passwordEncoder.encode(authUserInfo.getPassword()));
        authUserInfoDao.save(authUserInfo);
        return authUserInfo;
    }

    @Override
    public void deleteById(Long id) {
        authUserInfoDao.deleteById(id);
    }
}