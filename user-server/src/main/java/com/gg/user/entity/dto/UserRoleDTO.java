package com.gg.user.entity.dto;

import com.gg.user.entity.Role;
import com.gg.user.entity.UserInfo;
import lombok.Data;

/**
 * @author Gimi
 * @date 2020/4/23 14:29
 */
@Data
public class UserRoleDTO {

    private UserInfo userInfo;
    private Role role;

    public UserRoleDTO(UserInfo userInfo, Role role ){
        this.role = role;
        this.userInfo = userInfo;
    }
}
