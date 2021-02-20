package com.daiqi.yun.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.daiqi.yun.entity.ClassificationInfo;
import org.springframework.stereotype.Repository;

/**
 * @program: yun
 * @description: 自选列表dao
 * @author: Su.Qing
 * @create: 2021-02-18 11:13
 **/
@Repository
public interface InfoDao extends BaseMapper<ClassificationInfo> {
}
