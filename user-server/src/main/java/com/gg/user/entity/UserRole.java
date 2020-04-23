package com.gg.user.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * (AuthUserRole)实体类
 *
 * @author makejava
 * @since 2020-04-22 16:32:17
 */
@Data
@Entity
@Table(name = "auth_user_role")
public class UserRole implements Serializable {
    private static final long serialVersionUID = 554406303893396480L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long userId;
    
    private Long roleId;




}