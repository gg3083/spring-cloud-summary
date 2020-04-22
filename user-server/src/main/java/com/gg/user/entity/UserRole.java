package com.gg.user.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
    private Long id;
    
    private Integer userId;
    
    private Integer roleId;




}