package com.daiqi.yun.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @program: com.daiqi.yun
 * @description: 自选列表DTO
 * @author: Su.Qing
 * @create: 2021-02-24 15:11
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoDto implements Serializable {

    private static final long serialVersionUID = -4335582052013778287L;

    private Long id;

    /**用户id*/
    private String userId;

    /**分类id*/
    private Long typeId;

    /**股票代码*/
    private String stockCode;

    /**加入价格*/
    private BigDecimal createPrice;

    /**备注*/
    private String beizhu;

    /**创建时间*/
    private Timestamp createTime;


}
