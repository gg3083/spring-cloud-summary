package com.gg.backend.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

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

    private final static Integer DEFAULT_PAGE_NO = 1;
    private final static Integer DEFAULT_PAGE_SIZE = 10;

    public PageInfo(Page page){
        this.pageNo = page.getNumber();
        this.pageSize = page.getSize();
        this.totals = page.getTotalElements();
        this.data = page.getContent();
    }

    public PageInfo(com.github.pagehelper.PageInfo<T> pageInfo){
        this.pageNo = pageInfo.getPageNum();
        this.pageSize = pageInfo.getSize();
        this.totals = pageInfo.getTotal();
        this.data = pageInfo.getList();
    }

    public static PageRequest startPage(Integer pageNo, Integer pageSize){
        if (StringUtils.isEmpty(pageNo) || pageNo < 1){
            pageNo = DEFAULT_PAGE_NO;
        }
        if (StringUtils.isEmpty(pageSize) || pageSize == 0){
            pageSize = DEFAULT_PAGE_SIZE;
        }
        return PageRequest.of(pageNo-1, pageSize, Sort.by(Sort.Direction.DESC,"id"));
    }

}
