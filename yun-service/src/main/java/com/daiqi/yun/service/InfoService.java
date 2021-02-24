package com.daiqi.yun.service;

import com.daiqi.yun.dto.InfoDto;
import com.daiqi.yun.vo.ResponseVo;
import com.daiqi.yun.entity.ClassificationInfo;


/**
 * @program: com.daiqi.yun
 * @description: 自选列表service
 * @author: Su.Qing
 * @create: 2021-02-18 14:22
 **/
public interface InfoService {

    /**
    * @Description: 根据用户id和分类id获取分类的自选列表
    * @Param: [page, rows, userId, typeId]
    * @return: java.util.List<com.daiqi.com.daiqi.yun.entity.ClassificationInfo>
    * @Author: Su.Qing
    * @Date: 2021/2/19
    */
    ResponseVo<ClassificationInfo> getInfoByUserIdAndTypeId(Long page, Long rows, String userId, Long typeId);

    /**
    * @Description: 根据股票代码获取某个自选信息
    * @Param: [userId, stockCode]
    * @return: com.daiqi.com.daiqi.yun.entity.ClassificationInfo
    * @Author: Su.Qing
    * @Date: 2021/2/19
    */
    InfoDto getOneInfo(Long id);

    /**
    * @Description: 新增一个自选
    * @Param: [info]
    * @return: boolean
    * @Author: Su.Qing
    * @Date: 2021/2/19
    */
    boolean addInfo(InfoDto info);

    /**
    * @Description: 修改
    * @Param: [id, typeId, description]
    * @return: boolean
    * @Author: Su.Qing
    * @Date: 2021/2/19
    */
    boolean updateInfo(Long id, Long typeId, String description);

    /**
    * @Description: 删除一个自选
    * @Param: [userId, stockCode]
    * @return: boolean
    * @Author: Su.Qing
    * @Date: 2021/2/19
    */
    boolean deleteInfo(Long id);
}
