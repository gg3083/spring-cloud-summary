package com.gg.backend.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Gimi
 * @date 2019/8/16 10:25
 */
@Data
@ApiModel(value = "分页对象", description = "用户添加参数")
public class PageInfo<T> {
    @ApiModelProperty(value = "当前页")
    private long pageNo;
    @ApiModelProperty(value = "页条数")
    private long pageSize;
    @ApiModelProperty(value = "总数")
    private long totals;
    @ApiModelProperty(value = "内容")
    private List<T> data;

    public PageInfo(com.github.pagehelper.PageInfo<T> pageInfo){
        this.pageNo = pageInfo.getPageNum();
        this.pageSize = pageInfo.getSize();
        this.totals = pageInfo.getTotal();
        this.data = pageInfo.getList();
    }

}
