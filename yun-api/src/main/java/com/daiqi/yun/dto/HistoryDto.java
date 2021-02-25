package com.daiqi.yun.dto;

import com.daiqi.yun.constant.HistoryStatusConstant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @program: com.daiqi.yun
 * @description: 历史自选Dto
 * @author: Su.Qing
 * @create: 2021-02-24 15:12
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoryDto implements Serializable {

    private static final long serialVersionUID = 7890262640172977227L;

    private Long id;

    /**自选列表id*/
    private Long infoId;

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

    /**状态*/
    private Integer status;

    /**创建时间*/
    private Timestamp createTime;
}
