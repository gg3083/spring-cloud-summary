package com.example.backend.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author GG
 * @date 2019/1/23 13:39
 */
@Data
@Table(name = "t_user")
public class User {

    @Column(name = "pk_user_id")
    private Integer id;
    private String userName;
    private Integer userPwd;
    private Date createTime;
    private Integer isDelete;
}
