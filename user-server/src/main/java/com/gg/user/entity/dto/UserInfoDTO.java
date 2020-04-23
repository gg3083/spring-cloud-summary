package com.gg.user.entity.dto;

import com.gg.user.entity.Route;
import com.gg.user.entity.UserInfo;
import lombok.Data;

import java.util.List;

/**
 * @author Gimi
 * @date 2020/4/23 14:24
 */
@Data
public class UserInfoDTO {

    private UserInfo userInfo;
    private String roleName;
    private String roleDesc;
    private List<Route> routes;


    
}
