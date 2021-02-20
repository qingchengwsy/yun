package com.daiqi.yun.vo;

import lombok.Data;

import java.util.List;

/**
 * @program: yun
 * @description: view Object
 * @author: Su.Qing
 * @create: 2021-02-19 15:08
 **/
@Data
public class ResponseVo<T> {

    /**当前页*/
    private Long current;

    /**页面大小*/
    private Long size;

    /**总页数*/
    private Long pages;

    /**总记录数*/
    private Long total;

    /**分页记录列表*/
    private List<T> record;
}
