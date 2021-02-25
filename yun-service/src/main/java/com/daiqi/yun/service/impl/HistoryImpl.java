package com.daiqi.yun.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.daiqi.yun.api.HistoryApi;
import com.daiqi.yun.constant.HistoryStatusConstant;
import com.daiqi.yun.dao.HistoryDao;
import com.daiqi.yun.entity.ClassificationHistory;
import com.daiqi.yun.entity.ClassificationInfo;
import com.daiqi.yun.service.HistoryService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @program: com.daiqi.yun
 * @description:
 * @author: Su.Qing
 * @create: 2021-02-18 14:26
 **/
@Service
@DubboService(interfaceClass = HistoryApi.class)
public class HistoryImpl implements HistoryService, HistoryApi {

    @Autowired
    private HistoryDao historyDao;

    @Override
    public boolean addHistory(ClassificationInfo info, HistoryStatusConstant status) {
        ClassificationHistory history=new ClassificationHistory();
        BeanUtil.copyProperties(info,history, info.getId().toString());
        history.setInfoId(info.getId());
        history.setStatus(status);
        return historyDao.insert(history)==1;
    }
}
