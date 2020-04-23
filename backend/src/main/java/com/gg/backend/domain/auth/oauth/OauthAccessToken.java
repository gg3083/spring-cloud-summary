package com.gg.backend.domain.auth.oauth;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * (OauthAccessToken)实体类
 *
 * @author makejava
 * @since 2020-04-23 15:38:24
 */
@Data
@Entity
@Table(name = "oauth_access_token")
public class OauthAccessToken implements Serializable {
    private static final long serialVersionUID = -92200437810332575L;

    @Id
    private String tokenId;
    
    private String token;
    
    private String authenticationId;
    
    private String userName;
    
    private String clientId;
    
    private String authentication;
    
    private String refreshToken;


}