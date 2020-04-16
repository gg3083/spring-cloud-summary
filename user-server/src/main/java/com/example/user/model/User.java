package com.gg.user.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author Gimi
 * @date 2020/4/8 15:52
 */
@Data
@Builder
public class User {


    private String name;
    private String password;
}
