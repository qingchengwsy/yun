package com.daiqi.yun.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.daiqi.yun.dao.TypeDao;
import com.daiqi.yun.entity.ClassificationType;
import com.daiqi.yun.service.TypeService;
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
    public List<ClassificationType> findSubordinateByUserIdAndParentId(Long parentId) {
        List<ClassificationType> classificationTypeList = new ArrayList<>();
        ClassificationType classificationType = typeDao.selectById(parentId);
        classificationTypeList.add(classificationType);
        while (classificationType.getIsParent() != 0) {
            classificationType = typeDao.selectById(classificationType.getIsParent());
            classificationTypeList.add(classificationType);
        }
        return classificationTypeList;
    }

    @Override
    public boolean addType(ClassificationType classificationType) {
        return typeDao.insert(classificationType) == 1;
    }

    @Override
    public boolean updateType(Long id, String name, String description) {
        LambdaUpdateWrapper<ClassificationType> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(ClassificationType::getId, id).set(StrUtil.isNotBlank(name), ClassificationType::getFeileiName, name)
                .set(StrUtil.isNotBlank(description), ClassificationType::getFeileiZhushi, description);
        int update = typeDao.update(null, wrapper);
        return update == 1;
    }

    @Override
    public boolean deleteType(Long id) {
        List<Long> ids = this.findSubordinateByUserIdAndParentId(id)
                .stream().map(ClassificationType::getId).collect(Collectors.toList());
        int deleteBatchIds = typeDao.deleteBatchIds(ids);
        return deleteBatchIds == 1;
    }
}
