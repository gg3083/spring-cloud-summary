package com.gg.user.entity.oauth;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * (OauthApprovals)实体类
 *
 * @author makejava
 * @since 2020-04-23 15:38:24
 */
@Data
@Entity
@Table(name = "oauth_approvals")
public class OauthApprovals implements Serializable {
    private static final long serialVersionUID = -47798371936337272L;

    @Id
    private String userid;
    
    private String clientid;
    
    private String scope;
    
    private String status;
    
    private Date expiresat;
    
    private Date lastmodifiedat;



}