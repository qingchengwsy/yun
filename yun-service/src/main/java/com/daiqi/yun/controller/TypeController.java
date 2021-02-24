package com.daiqi.yun.controller;

import com.daiqi.yun.dto.TypeDto;
import com.daiqi.yun.service.TypeService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: com.daiqi.yun
 * @description: 自选分类 controller
 * @author: Su.Qing
 * @create: 2021-02-19 09:27
 **/
@RestController
@RequestMapping("type")
public class TypeController {

    @GetMapping("get")
    public List<TypeDto> get(){
      return null;
    }

}
