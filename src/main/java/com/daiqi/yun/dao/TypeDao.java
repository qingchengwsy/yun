package com.daiqi.yun.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.daiqi.yun.entity.ClassificationType;
import org.springframework.stereotype.Repository;

/**
 * @program: yun
 * @description: 自选分类dao
 * @author: Su.Qing
 * @create: 2021-02-18 11:15
 **/
@Repository
public interface TypeDao extends BaseMapper<ClassificationType> {
}
