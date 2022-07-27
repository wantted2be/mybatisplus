package com.company.mybatisplusdatasource.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.company.mybatisplusdatasource.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @Author wlb10
 * @PackageName mybatisplus
 * @Package com.company.mybatisplusdatasource.mapper
 * @Date 2022/7/27 10:04
 * @Version 1.0
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
