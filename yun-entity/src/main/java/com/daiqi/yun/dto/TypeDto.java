package com.daiqi.yun.dto;

import com.daiqi.yun.constant.TypeStatusConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @program: com.daiqi.yun
 * @description: 自选分类DTO
 * @author: Su.Qing
 * @create: 2021-02-24 15:11
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TypeDto implements Serializable {

    private static final long serialVersionUID = 3854529113348785780L;

    private Long id;

    /**用户id*/
    private String userId;

    /**分类名称*/
    private String feileiName;

    /**父类id*/
    private Long isParent;

    /**分类注释*/
    private String feileiZhushi;

    /**状态*/
    private TypeStatusConstant status;

    /**创建时间*/
    private Timestamp createTime;
}
