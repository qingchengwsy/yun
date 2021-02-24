package com.daiqi.yun.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.daiqi.yun.dto.TypeDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.daiqi.yun.dao.TypeDao;
import com.daiqi.yun.entity.ClassificationType;
import com.daiqi.yun.service.TypeService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: com.daiqi.yun
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
    public List<TypeDto> findTopByUserId(String userId) {
        LambdaQueryWrapper<ClassificationType> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ClassificationType::getUserId, userId);
        return typeDao.selectList(wrapper).stream()
                .map(this::typeToTypeDto).collect(Collectors.toList());
    }

    @Override
    public List<TypeDto> findSubordinateByParentId(Long parentId) {
        LambdaUpdateWrapper<ClassificationType> wrapper=new LambdaUpdateWrapper<>();
        wrapper.eq(ClassificationType::getIsParent,parentId);
        return typeDao.selectList(wrapper).stream()
                .map(this::typeToTypeDto).collect(Collectors.toList());
    }

    @Override
    public boolean addType(TypeDto typeDto) {
        ClassificationType classificationType=new ClassificationType();
        BeanUtil.copyProperties(typeDto,classificationType);
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
        List<ClassificationType> parentId = this.findTypeById(type.getId());
        if (CollectionUtil.isNotEmpty(parentId)){
            for (ClassificationType classificationType : parentId) {
                queryAllNode(classificationType,typeList);
            }
        }
    }

    /**
    * @Description: 根据上级id查询下级分类
    * @Param: [parentId]
    * @return: java.util.List<com.daiqi.com.daiqi.yun.entity.ClassificationType>
    * @Author: Su.Qing
    * @Date: 2021/2/24
    */
    private List<ClassificationType> findTypeById(Long parentId) {
        LambdaUpdateWrapper<ClassificationType> wrapper=new LambdaUpdateWrapper<>();
        wrapper.eq(ClassificationType::getIsParent,parentId);
        return typeDao.selectList(wrapper);
    }


    /**
    * @Description: 将ClassificationType转换为TypeDto
    * @Param: [type]
    * @return: com.daiqi.com.daiqi.yun.dto.TypeDto
    * @Author: Su.Qing
    * @Date: 2021/2/24
    */
    private TypeDto typeToTypeDto(ClassificationType type){
        return new TypeDto(
                type.getId(),
                type.getUserId(),
                type.getFeileiName(),
                type.getIsParent(),
                type.getFeileiZhushi(),
                type.getStatus(),
                type.getCreateTime()
        );
    }
}
