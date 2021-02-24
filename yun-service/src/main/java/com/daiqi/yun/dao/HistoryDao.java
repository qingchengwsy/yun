package com.daiqi.yun.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.daiqi.yun.entity.ClassificationHistory;
import org.springframework.stereotype.Repository;

/**
 * @program: com.daiqi.yun
 * @description: 历史自选dao
 * @author: Su.Qing
 * @create: 2021-02-18 11:15
 **/
@Repository
public interface HistoryDao extends BaseMapper<ClassificationHistory> {
}
