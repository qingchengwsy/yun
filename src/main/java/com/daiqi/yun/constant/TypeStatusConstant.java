package com.daiqi.yun.constant;

/**
 * @program: yun
 * @description: 分类状态枚举
 * @author: Su.Qing
 * @create: 2021-02-18 10:10
 **/

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum TypeStatusConstant {

    STATUS_OPEN(1,"开启"),
    STATUS_CLOSE(2,"关闭");

    /**分类状态编码*/
    @EnumValue
    @JsonValue
    private Integer code;
    /**分类状态详情*/
    private String description;

    public static TypeStatusConstant of(Integer code){
        Objects.requireNonNull(code);
        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findAny()
                .orElseThrow(()->new IllegalArgumentException(code+" not exists"));
    }
}
