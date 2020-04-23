package com.gg.backend.domain.dto;

import com.gg.backend.domain.auth.Role;
import com.gg.backend.domain.auth.UserInfo;
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
