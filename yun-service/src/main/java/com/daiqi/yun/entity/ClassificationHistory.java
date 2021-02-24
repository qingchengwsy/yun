package com.daiqi.yun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.daiqi.yun.constant.HistoryStatusConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @program: com.daiqi.yun
 * @description: 自选列表历史操作
 * @author: Su.Qing
 * @create: 2021-02-18 11:09
 **/
@TableName(value = "classification__history")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassificationHistory {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**自选列表id*/
    @TableField(value = "info_id")
    private Long infoId;

    /**用户id*/
    @TableField(value = "user_id")
    private String userId;

    /**分类id*/
    @TableField(value = "type_id")
    private Long typeId;

    /**股票代码*/
    @TableField(value = "stock_code")
    private String stockCode;

    /**加入价格*/
    @TableField(value = "create_price")
    private BigDecimal createPrice;

    /**备注*/
    @TableField(value = "beizhu")
    private String beizhu;

    /**状态*/
    @TableField(value = "status")
    private HistoryStatusConstant status;

    /**创建时间*/
    @TableField(value = "create_time")
    private Timestamp createTime;

}
