package com.gg.backend.controller;

import com.gg.backend.domain.Goods;
import com.gg.backend.domain.dto.JsonBack;
import com.gg.backend.mapper2.GoodsMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/***
 *
 * @author Gimi
 * @date 2020/4/21 20:21
 *
 ***/
@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    GoodsMapper goodsMapper;

    @GetMapping("list")
    public JsonBack list(Integer pageNo,Integer pageSize){
        PageHelper.startPage(pageNo, pageSize);
        List<Goods> goods = goodsMapper.selectAll();
        PageInfo<Goods> goodsPageInfo = new PageInfo<>(goods);
        return new JsonBack(new com.gg.backend.domain.dto.PageInfo(goodsPageInfo));
    }

}
