package com.gg.user.entity.oauth;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * (OauthRefreshToken)实体类
 *
 * @author makejava
 * @since 2020-04-23 15:38:24
 */
@Data
@Entity
@Table(name = "oauth_refresh_token")
public class OauthRefreshToken implements Serializable {
    private static final long serialVersionUID = 952271288931079011L;

    @Id
    private String tokenId;
    
    private String token;
    
    private String authentication;


}