package com.gg.backend.domain.auth;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * (AuthRole)实体类
 *
 * @author makejava
 * @since 2020-04-22 16:32:16
 */
@Data
@Entity
@Table(name = "auth_role")
public class Role implements Serializable {
    private static final long serialVersionUID = -78553782515870592L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String roleName;
    
    private String roleDesc;
    
    private Integer deleteState;
    
    private LocalDateTime createTime;
    
    private LocalDateTime updateTime;



}