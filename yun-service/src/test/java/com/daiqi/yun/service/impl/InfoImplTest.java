package com.daiqi.yun.service.impl;

import cn.hutool.core.lang.Assert;
import com.daiqi.yun.dto.InfoDto;
import com.daiqi.yun.vo.ResponseVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.daiqi.yun.service.InfoService;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class InfoImplTest {

    @Autowired
    private InfoService infoService;

    private static final String USER_ID="001-001-001-001";

    @Test
    void getInfoByUserIdAndTypeId() {
        ResponseVo<InfoDto> info = infoService.getInfoByUserIdAndTypeId(1L, 10L, USER_ID, 32L);
        System.out.println(info);
        Assert.notEmpty(info.getRecord());
    }

    @Test
    void getOneInfo() {
        InfoDto oneInfo = infoService.getOneInfo(1L);
        System.out.println(oneInfo);
        Assert.notEmpty(oneInfo.getUserId());
    }

    @Test
    void addInfo() {
        InfoDto info=new InfoDto();
        info.setUserId(USER_ID);
        info.setTypeId(32L);
        info.setStockCode("001-002");
        info.setCreatePrice(new BigDecimal("0.01"));
        boolean insert = infoService.addInfo(info);
        Assert.isTrue(insert);
    }

    @Test
    void updateInfo() {
        boolean updateInfo = infoService.updateInfo(1L, null, "2222");
        Assert.isTrue(updateInfo);
    }

    @Test
    void deleteInfo() {
        boolean del = infoService.deleteInfo(1L);
        Assert.isTrue(del);
    }
}
