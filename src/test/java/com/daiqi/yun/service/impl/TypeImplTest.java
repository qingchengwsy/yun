package com.daiqi.yun.service.impl;

import cn.hutool.core.lang.Assert;
import com.daiqi.yun.constant.TypeStatusConstant;
import com.daiqi.yun.entity.ClassificationType;
import com.daiqi.yun.service.TypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TypeImplTest {

    @Autowired
    private TypeService typeService;

    private static final String USER_ID="001-001-001-001";

    @Test
    void findTopByUserId() {
        List<ClassificationType> topByUserId = typeService.findTopByUserId(USER_ID);
        System.out.println(topByUserId);
        Assert.notEmpty(topByUserId);
    }

    @Test
    void findSubordinateByUserIdAndParentId() {
        List<ClassificationType> subordinateByUserIdAndParentId = typeService.findSubordinateByParentId(15L);
        System.out.println(subordinateByUserIdAndParentId);
        Assert.notEmpty(subordinateByUserIdAndParentId);
    }

    @Test
    void addType() {
        ClassificationType type=new ClassificationType();
        type.setFeileiName("理财");
        type.setIsParent(0L);
        type.setUserId(USER_ID);
        type.setStatus(TypeStatusConstant.STATUS_OPEN);
        boolean insert = typeService.addType(type);
        Assert.isTrue(insert);
    }

    @Test
    void updateType() {
        boolean update = typeService.updateType(15L, null, null);
        Assert.isFalse(update);
    }

    @Test
    void deleteType() {
        boolean del = typeService.deleteType(27L);
        Assert.isTrue(del);
    }
}
