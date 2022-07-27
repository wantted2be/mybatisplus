package com.company.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.company.mybatisplus.enums.SexEnum;
import lombok.*;

/**
 * @Author wlb10
 * @PackageName mybatisplus
 * @Package com.company.mybatisplus.pojo
 * @Date 2022/7/25 21:42
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName("t_user")
public class User {
    //mybatisplus默认将id作为主键列，插入数据使用雪花算法，这个标签可以设置其它字段名字作为id列
    //value可设置实体类和表的列名不一致的情况，用于指定主键字段
    //type可以设置数据库主键的自增情况，IdType.AUTO表示自增，IdType.ASSIGN_ID表示使用雪花算法
    @TableId(value = "uid", type = IdType.ASSIGN_ID)
    private Long id;

    //用来指定属性对应的表里面的字段名，默认情况下mybatisplus支持将数据库的下划线转化为小驼峰命名法
    @TableField("name")
    private String name;

    private Integer age;

    private String email;

    private SexEnum sex;

    @TableLogic
    private Integer isDeleted;
}
