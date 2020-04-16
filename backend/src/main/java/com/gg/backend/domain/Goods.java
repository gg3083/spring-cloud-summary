package com.gg.backend.domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * @author GG
 * @date 2019/1/23 13:39
 */
@Entity(name = "t_goods")
@Data
public class Goods {

    @Column(name = "pk_goods_id")
    private Integer id;
    private String goodsName;
    private Integer goodsType;
    private Double goodsPrice;
    private Date createTime;
    private Integer isDelete;

}
