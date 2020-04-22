package com.gg.user;

import com.gg.user.dao.AuthUserInfoDao;
import com.gg.user.entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserServerApplicationTests {

    @Autowired
    AuthUserInfoDao userInfoDao;
    @Test
    void contextLoads() {
        List<UserInfo> all = userInfoDao.findAll();
        all.forEach(System.out::println);
    }

}
