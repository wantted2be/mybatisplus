package com.company.mybatisplusdatasource.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author wlb10
 * @PackageName mybatisplus
 * @Package com.company.mybatisplus.pojo
 * @Date 2022/7/27 7:32
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("product")
public class Product {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    private String name;

    private Integer price;

    @Version
    private Integer version;
}
