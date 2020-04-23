package com.gg.user.entity.oauth;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * (OauthCode)实体类
 *
 * @author makejava
 * @since 2020-04-23 15:38:24
 */
@Data
@Entity
@Table(name = "oauth_code")
public class OauthCode implements Serializable {
    private static final long serialVersionUID = -43885157495560868L;

    @Id
    private String code;
    
    private String authentication;



}