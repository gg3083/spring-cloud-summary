package com.gg.user;

import com.gg.user.controller.AuthUserInfoController;
import com.gg.user.entity.UserInfo;
import com.gg.user.entity.dto.UserInfoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class UserServerApplicationTests {

    @Autowired
    AuthUserInfoController userInfoDao;
    @Test
    void contextLoads() {
        for (int i = 10; i < 30 ; i++) {
            UserInfoDTO userInfoDTO = new UserInfoDTO();
            UserInfo userInfo = new UserInfo();
            userInfo.setPassword("123456");
            userInfo.setBirthday(LocalDate.now());
            userInfo.setCreateTime(LocalDateTime.now());
            userInfo.setUpdateTime(LocalDateTime.now());
            userInfo.setUserName("user"+i);
            userInfo.setRealName("李四"+i);
            userInfo.setSex(i%2);
            userInfoDTO.setUserInfo(userInfo);
            userInfoDao.save(userInfoDTO);
        }

    }

}
