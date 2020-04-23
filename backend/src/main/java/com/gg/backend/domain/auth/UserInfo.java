package com.gg.backend.domain.auth;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * (AuthUserInfo)实体类
 *
 * @author makejava
 * @since 2020-04-22 16:32:17
 */
@Data
@Entity
@Table(name = "auth_user_info")
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -91924524945995395L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String userName;
    
    private String realName;
    
    private String password;

    private String phone;
    
    private Integer sex;
    
    private LocalDate birthday;

    private String serverName;

    private String serverId;

    @Column(nullable=false,name="create_time",columnDefinition="datetime DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createTime;

    @Column(nullable=false,name="update_time",columnDefinition="datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0)")
    private LocalDateTime updateTime;



}