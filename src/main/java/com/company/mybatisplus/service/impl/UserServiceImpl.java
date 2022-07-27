package com.company.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.mybatisplus.mapper.UserMapper;
import com.company.mybatisplus.pojo.User;
import com.company.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @Author wlb10
 * @PackageName mybatisplus
 * @Package com.company.mybatisplus.service.impl
 * @Date 2022/7/26 10:28
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
