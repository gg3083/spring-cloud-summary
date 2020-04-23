package com.gg.backend.domain.dto;

import com.gg.backend.domain.auth.Route;
import com.gg.backend.domain.auth.UserInfo;
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
