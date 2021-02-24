package com.daiqi.yun.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: com.daiqi.yun
 * @description: nacos配置自动更新
 * @author: Su.Qing
 * @create: 2021-02-22 11:13
 **/
@RestController
@RequestMapping("/config")
@RefreshScope
@Slf4j
public class NacosConfigController {

   @Value("${useLocalCache:false}")
    private boolean useLocalCache;

    @RequestMapping("/test")
    public boolean get() {
        return useLocalCache;
    }
}
