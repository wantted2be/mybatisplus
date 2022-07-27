package com.company.mybatisplus.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @Author wlb10
 * @PackageName mybatisplus
 * @Package com.company.mybatisplus.enums
 * @Date 2022/7/27 8:42
 * @Version 1.0
 */
@Getter
public enum SexEnum {
    MALE(1,"男"),
    FEMALE(2, "女");

    @EnumValue
    private Integer sex;
    private String sexName;

    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
