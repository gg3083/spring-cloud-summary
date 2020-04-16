package com.gg.backend.mapper1;

import com.gg.backend.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GG
 * @date 2019/1/23 19:12
 */
public interface UserMapper {

    void insert(@Param("userName") String userName, @Param("userPwd") String userPwd);

    List<User> selectAll();
}
