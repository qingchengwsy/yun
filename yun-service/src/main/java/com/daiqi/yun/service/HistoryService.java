package com.daiqi.yun.service;

import com.daiqi.yun.constant.HistoryStatusConstant;
import com.daiqi.yun.entity.ClassificationInfo;

/**
 * @program: com.daiqi.yun
 * @description: 历史自选
 * @author: Su.Qing
 * @create: 2021-02-18 14:25
 **/
public interface HistoryService{

    /**
    * @Description: 添加历史自选操作记录
    * @Param: [infoId, status]
    * @return: boolean
    * @Author: Su.Qing
    * @Date: 2021/2/19
    */
    boolean addHistory(ClassificationInfo info, HistoryStatusConstant status);
}
