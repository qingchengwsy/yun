package com.daiqi.yun.service.impl;

import cn.hutool.core.lang.Assert;
import com.daiqi.yun.constant.TypeStatusConstant;
import com.daiqi.yun.entity.ClassificationType;
import com.daiqi.yun.service.TypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TypeImplTest {

    @Autowired
    private TypeService typeService;

    private static final String USER_ID="001-001-001-001";

    @Test
    void findTopByUserId() {
    }

    @Test
    void findSubordinateByUserIdAndParentId() {
    }

    @Test
    void addType() {
        ClassificationType type=new ClassificationType();
        type.setFeileiName("½ðÈÚ");
        type.setIsParent(0L);
        type.setUserId(USER_ID);
        type.setStatus(TypeStatusConstant.STATUS_OPEN);
        boolean insert = typeService.addType(type);
        Assert.isTrue(insert);
    }

    @Test
    void updateType() {
    }

    @Test
    void deleteType() {
    }
}
