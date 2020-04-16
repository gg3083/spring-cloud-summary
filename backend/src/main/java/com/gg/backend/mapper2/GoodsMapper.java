package com.gg.backend.mapper2;

import com.gg.backend.domain.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author GG
 * @date 2019/1/23 19:13
 */
public interface GoodsMapper {

    void insert(@Param("goodsName") String goodsName, @Param("goodsType") Integer goodsType, @Param("goodsPrice") Double goodsPrice);

    List<Goods> selectAll();
}
