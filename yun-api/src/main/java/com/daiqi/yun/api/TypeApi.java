package com.daiqi.yun.api;

import com.daiqi.yun.dto.TypeDto;

import java.util.List;

/**
 * @program: com.daiqi.yun
 * @description: 自选分类接口
 * @author: Su.Qing
 * @create: 2021-02-24 15:10
 **/
public interface TypeApi {

    /**
     * @Description: 查询用户所有顶级分类
     * @Param: [userId]
     * @return: java.util.List<com.daiqi.com.daiqi.yun.entity.ClassificationType>
     * @Author: Su.Qing
     * @Date: 2021/2/18
     */
    List<TypeDto> findTopByUserId(String userId);

    /**
     * @Description: 根据父类id查询下级id
     * @Param: [userId, parentId]
     * @return: java.util.List<com.daiqi.com.daiqi.yun.entity.ClassificationType>
     * @Author: Su.Qing
     * @Date: 2021/2/18
     */
    List<TypeDto> findSubordinateByParentId(Long parentId);

    /**
     * @Description: 新增分类
     * @Param: [classificationType]
     * @return: void
     * @Author: Su.Qing
     * @Date: 2021/2/18
     */
    boolean addType(TypeDto typeDto);

    /**
     * @Description: 修改分类
     * @Param: [id, name, description]
     * @return: void
     * @Author: Su.Qing
     * @Date: 2021/2/18
     */
    boolean updateType(Long id, String name, String description);

    /**
     * @Description: 删除分类
     * @Param: [id]
     * @return: void
     * @Author: Su.Qing
     * @Date: 2021/2/18
     */
    boolean deleteType(Long id);
}
