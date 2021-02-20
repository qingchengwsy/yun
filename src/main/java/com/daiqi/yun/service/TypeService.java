package com.daiqi.yun.service;

import com.daiqi.yun.entity.ClassificationType;

import java.util.List;

/**
 * @program: yun
 * @description: 自选分类service
 * @author: Su.Qing
 * @create: 2021-02-18 14:24
 **/
public interface TypeService {

    /**
    * @Description: 查询用户所有顶级分类
    * @Param: [userId]
    * @return: java.util.List<com.daiqi.yun.entity.ClassificationType>
    * @Author: Su.Qing
    * @Date: 2021/2/18
    */
    List<ClassificationType> findTopByUserId(String userId);

    /**
    * @Description: 根据用户和父类id查询下级id
    * @Param: [userId, parentId]
    * @return: java.util.List<com.daiqi.yun.entity.ClassificationType>
    * @Author: Su.Qing
    * @Date: 2021/2/18
    */
    List<ClassificationType> findSubordinateByUserIdAndParentId(Long parentId);

    /**
    * @Description: 新增分类
    * @Param: [classificationType]
    * @return: void
    * @Author: Su.Qing
    * @Date: 2021/2/18
    */
    boolean addType(ClassificationType classificationType);

    /**
    * @Description: 修改分类
    * @Param: [id, name, description]
    * @return: void
    * @Author: Su.Qing
    * @Date: 2021/2/18
    */
    boolean updateType(Long id,String name,String description);

    /**
    * @Description: 删除分类
    * @Param: [id]
    * @return: void
    * @Author: Su.Qing
    * @Date: 2021/2/18
    */
    boolean deleteType(Long id);

}
