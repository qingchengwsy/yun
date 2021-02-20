package com.daiqi.yun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @program: yun
 * @description: 自选列表 实体
 * @author: Su.Qing
 * @create: 2021-02-18 09:47
 **/
@TableName(value = "classification_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassificationInfo {

    @TableId(type = IdType.AUTO)
    private Long id;

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

    /**创建时间*/
    @TableField(value = "create_time")
    private Timestamp createTime;


}
