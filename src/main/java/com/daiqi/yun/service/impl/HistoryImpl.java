package com.daiqi.yun.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.daiqi.yun.constant.HistoryStatusConstant;
import com.daiqi.yun.dao.HistoryDao;
import com.daiqi.yun.entity.ClassificationHistory;
import com.daiqi.yun.entity.ClassificationInfo;
import com.daiqi.yun.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: yun
 * @description:
 * @author: Su.Qing
 * @create: 2021-02-18 14:26
 **/
@Service
public class HistoryImpl implements HistoryService {

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
