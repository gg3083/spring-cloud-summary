package com.gg.user.service.impl;

import com.gg.user.entity.UserInfo;
import com.gg.user.dao.AuthUserInfoDao;
import com.gg.user.service.AuthUserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public UserInfo queryById(Integer id) {
        return null;
    }

    @Override
    public List<UserInfo> queryAllByLimit(int offset, int limit) {
        return null;
    }

    @Override
    public UserInfo insert(UserInfo authUserInfo) {
        return null;
    }

    @Override
    public UserInfo update(UserInfo authUserInfo) {
        return null;
    }

    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
}