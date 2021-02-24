package com.daiqi.yun.service.impl;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.daiqi.yun.dao.TypeDao;
import com.daiqi.yun.entity.ClassificationType;
import com.daiqi.yun.service.TypeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: yun
 * @description:
 * @author: Su.Qing
 * @create: 2021-02-18 14:25
 **/
@Service
@DubboService
@Slf4j
public class TypeImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    public List<ClassificationType> findTopByUserId(String userId) {
        LambdaQueryWrapper<ClassificationType> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ClassificationType::getUserId, userId);
        return typeDao.selectList(wrapper);
    }

    @Override
    public List<ClassificationType> findSubordinateByParentId(Long parentId) {
        LambdaUpdateWrapper<ClassificationType> wrapper=new LambdaUpdateWrapper<>();
        wrapper.eq(ClassificationType::getIsParent,parentId);
        return typeDao.selectList(wrapper);
    }

    @Override
    public boolean addType(ClassificationType classificationType) {
        return typeDao.insert(classificationType) == 1;
    }

    @Override
    public boolean updateType(Long id, String name, String description) {
        if (StrUtil.isBlank(name)&&StrUtil.isBlank(description)){
            log.error("分类菜单和备注必须有一项不为空");
            return false;
        }
        LambdaUpdateWrapper<ClassificationType> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(ClassificationType::getId, id).set(StrUtil.isNotBlank(name), ClassificationType::getFeileiName, name)
                .set(StrUtil.isNotBlank(description), ClassificationType::getFeileiZhushi, description);
        int update = typeDao.update(null, wrapper);
        return update == 1;
    }

    @Override
    public boolean deleteType(Long id) {
        ClassificationType type = typeDao.selectById(id);
        List<ClassificationType> typeList=new ArrayList<>();
        queryAllNode(type,typeList);
        List<Long> ids = typeList.stream()
                .map(ClassificationType::getId).collect(Collectors.toList());
        int deleteBatchIds = typeDao.deleteBatchIds(ids);
        return deleteBatchIds>=1;
    }

    /**
    * @Description: 递归 查询此分类下的所有分类
    * @Param: [id, typeList]
    * @return: void
    * @Author: Su.Qing
    * @Date: 2021/2/23
    */
    private void queryAllNode(ClassificationType type,List<ClassificationType> typeList){
        typeList.add(type);
        List<ClassificationType> parentId = this.findSubordinateByParentId(type.getId());
        if (CollectionUtil.isNotEmpty(parentId)){
            for (ClassificationType classificationType : parentId) {
                queryAllNode(classificationType,typeList);
            }
        }
    }
}
