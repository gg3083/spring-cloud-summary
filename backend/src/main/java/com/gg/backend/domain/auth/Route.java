package com.gg.backend.domain.auth;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * (AuthRoute)实体类
 *
 * @author makejava
 * @since 2020-04-22 16:32:17
 */
@Data
@Entity
@Table(name = "auth_route")
public class Route implements Serializable {
    private static final long serialVersionUID = 474582743389207008L;

    @Id
    private Long id;
    
    private String serverName;
    
    private String urlAddress;
    
    private String urlDesc;

    /**
     * 路径类型
     * 系统路径 == 1
     *  业务路径 == 2
     * */
    private Integer type = 1;



}