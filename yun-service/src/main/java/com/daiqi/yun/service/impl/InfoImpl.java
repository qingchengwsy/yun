package com.daiqi.yun.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.daiqi.yun.api.InfoApi;
import com.daiqi.yun.constant.HistoryStatusConstant;
import com.daiqi.yun.dto.InfoDto;
import com.daiqi.yun.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import com.daiqi.yun.dao.InfoDao;
import com.daiqi.yun.entity.ClassificationInfo;
import com.daiqi.yun.service.HistoryService;
import com.daiqi.yun.service.InfoService;


/**
 * @program: com.daiqi.yun
 * @description:
 * @author: Su.Qing
 * @create: 2021-02-18 14:23
 **/
@Service
@DubboService
@Slf4j
public class InfoImpl implements InfoService, InfoApi {

    private InfoDao infoDao;
    private HistoryService historyService;

    public InfoImpl(InfoDao infoDao, HistoryService historyService) {
        this.infoDao = infoDao;
        this.historyService = historyService;
    }

    @Override
    public ResponseVo<ClassificationInfo> getInfoByUserIdAndTypeId(Long page, Long rows, String userId, Long typeId) {
        ResponseVo<ClassificationInfo> responseVo = null;
        LambdaQueryWrapper<ClassificationInfo> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ClassificationInfo::getUserId, userId)
                .eq(typeId != null, ClassificationInfo::getTypeId, typeId);
        IPage<ClassificationInfo> pageHelper = new Page<>(page, rows);
        pageHelper = infoDao.selectPage(pageHelper, wrapper);
        if (CollectionUtil.isNotEmpty(pageHelper.getRecords())) {
            responseVo = new ResponseVo<>();
            responseVo.setCurrent(pageHelper.getCurrent());
            responseVo.setPages(pageHelper.getPages());
            responseVo.setSize(pageHelper.getSize());
            responseVo.setTotal(pageHelper.getTotal());
            responseVo.setRecord(pageHelper.getRecords());
        }
        return responseVo;
    }

    @Override
    public InfoDto getOneInfo(Long id) {
        return infoToInfoDto(infoDao.selectById(id));
    }

    @Override
    public boolean addInfo(InfoDto info) {
        ClassificationInfo classificationInfo=new ClassificationInfo();
        BeanUtil.copyProperties(info,classificationInfo);
        if (infoDao.insert(classificationInfo) == 1) {
            return historyService.addHistory(classificationInfo, HistoryStatusConstant.STATUS_OPEN);
        }
        return false;
    }

    @Override
    public boolean updateInfo(Long id, Long typeId, String description) {
        if (typeId == null && StrUtil.isBlank(description)) {
            log.error("分类菜单和备注必须一项不为null");
            return false;
        }
        LambdaUpdateWrapper<ClassificationInfo> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(ClassificationInfo::getId, id)
                .set(typeId != null, ClassificationInfo::getTypeId, typeId)
                .set(StrUtil.isNotBlank(description), ClassificationInfo::getBeizhu, description);
        return infoDao.update(null, wrapper) == 1;
    }

    @Override
    public boolean deleteInfo(Long id) {
        ClassificationInfo info = infoDao.selectById(id);
        if (infoDao.deleteById(id) == 1) {
            return historyService.addHistory(info, HistoryStatusConstant.STATUS_CLOSE);
        }
        return false;
    }

    /**
    * @Description: ClassificationInfo转换为InfoDto
    * @Param: [info]
    * @return: com.daiqi.com.daiqi.yun.dto.InfoDto
    * @Author: Su.Qing
    * @Date: 2021/2/24
    */
    private InfoDto infoToInfoDto(ClassificationInfo info){
        return new InfoDto(
                info.getId(),
                info.getUserId(),
                info.getTypeId(),
                info.getStockCode(),
                info.getCreatePrice(),
                info.getBeizhu(),
                info.getCreateTime()
        );
    }

    @Override
    public String get() {
        return "1111111111";
    }
}
