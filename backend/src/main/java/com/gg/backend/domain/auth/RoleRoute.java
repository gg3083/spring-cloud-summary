package com.gg.backend.domain.auth;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * (AuthRoleRoute)实体类
 *
 * @author makejava
 * @since 2020-04-22 16:32:17
 */
@Data
@Entity
@Table(name = "auth_role_route")
public class RoleRoute implements Serializable {
    private static final long serialVersionUID = -95135913177685715L;

    @Id
    private Long id;
    
    private Integer roleId;
    
    private Integer routeId;



}