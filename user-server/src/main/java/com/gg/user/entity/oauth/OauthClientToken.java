package com.gg.user.entity.oauth;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * (OauthClientToken)实体类
 *
 * @author makejava
 * @since 2020-04-23 15:38:24
 */
@Data
@Entity
@Table(name = "oauth_client_token")
public class OauthClientToken implements Serializable {
    private static final long serialVersionUID = 191808056833260484L;

    @Id
    private String tokenId;
    
    private String token;
    
    private String authenticationId;
    
    private String userName;
    
    private String clientId;



}