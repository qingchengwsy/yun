package com.daiqi.yun.controller;

import com.daiqi.yun.service.TypeService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: yun
 * @description: 自选分类 controller
 * @author: Su.Qing
 * @create: 2021-02-19 09:27
 **/
@RestController
@RequestMapping("type")
public class TypeController {

    @Autowired
    private TypeService typeService;


}
