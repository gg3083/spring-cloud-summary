package com.gg.user.entity.oauth;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * (OauthClientDetails)实体类
 *
 * @author makejava
 * @since 2020-04-23 15:38:24
 */
@Data
@Entity
@Table(name = "oauth_client_details")
public class OauthClientDetails implements Serializable {
    private static final long serialVersionUID = -64193602777675201L;

    @Id
    private String clientId;
    
    private String resourceIds;
    
    private String clientSecret;
    
    private String scope;
    
    private String authorizedGrantTypes;
    
    private String webServerRedirectUri;
    
    private String authorities;
    
    private Integer accessTokenValidity;
    
    private Integer refreshTokenValidity;
    
    private String additionalInformation;
    
    private String autoapprove;



}