package com.gg.backend.domain.auth;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

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
    @Column(nullable=false,name="type",columnDefinition="tinyint(2) DEFAULT 1")
    private Integer type = 1;

    @Column(nullable=false,name="create_time",columnDefinition="datetime DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createTime;

    @Column(nullable=false,name="update_time",columnDefinition="datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0)")
    private LocalDateTime updateTime;

}