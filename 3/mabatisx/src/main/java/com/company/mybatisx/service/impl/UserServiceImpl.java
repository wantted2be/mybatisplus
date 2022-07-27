package com.company.mybatisx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.company.mybatisx.pojo.User;
import com.company.mybatisx.service.UserService;
import com.company.mybatisx.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author wlb10
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-07-27 10:55:02
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




