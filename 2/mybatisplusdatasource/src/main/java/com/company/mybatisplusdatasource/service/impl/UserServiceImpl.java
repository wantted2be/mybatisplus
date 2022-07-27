package com.company.mybatisplusdatasource.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.company.mybatisplusdatasource.mapper.UserMapper;
import com.company.mybatisplusdatasource.pojo.User;
import com.company.mybatisplusdatasource.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author wlb10
 * @PackageName mybatisplus
 * @Package com.company.mybatisplus.service.impl
 * @Date 2022/7/26 10:28
 * @Version 1.0
 */
@Service
@DS("master")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
