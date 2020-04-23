package com.gg.user.entity.oauth;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * (Clientdetails)实体类
 *
 * @author makejava
 * @since 2020-04-23 15:38:24
 */
@Data
@Entity
@Table(name = "clientdetails")
public class Clientdetails implements Serializable {
    private static final long serialVersionUID = -77259057751801888L;

    @Id
    private String appid;
    
    private String resourceids;
    
    private String appsecret;
    
    private String scope;
    
    private String granttypes;
    
    private String redirecturl;
    
    private String authorities;
    
    private Integer accessTokenValidity;
    
    private Integer refreshTokenValidity;
    
    private String additionalinformation;
    
    private String autoapprovescopes;



}