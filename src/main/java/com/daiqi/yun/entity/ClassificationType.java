package com.daiqi.yun.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.daiqi.yun.constant.TypeStatusConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @program: yun
 * @description: 自选分类表
 * @author: Su.Qing
 * @create: 2021-02-18 10:00
 **/
@TableName(value = "classification_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassificationType {

    @TableId(type = IdType.AUTO)
    private Long id;

    /**用户id*/
    @TableField(value = "user_id")
    private String userId;

    /**分类名称*/
    @TableField(value = "feilei_name")
    private String feileiName;

    /**父类id*/
    @TableField(value = "is_parent")
    private Long isParent;

    /**分类注释*/
    @TableField(value = "feilei_zhushi")
    private String feileiZhushi;

    /**状态*/
    @TableField(value = "status")
    private TypeStatusConstant status;

    /**创建时间*/
    @TableField(value = "create_time")
    private Timestamp createTime;
}
