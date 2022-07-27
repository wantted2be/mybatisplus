package com.company.mybatisplus;

import com.company.mybatisplus.pojo.User;
import com.company.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

/**
 * @Author wlb10
 * @PackageName mybatisplus
 * @Package com.company.mybatisplus
 * @Date 2022/7/26 10:30
 * @Version 1.0
 */
@SpringBootTest
public class MyBatisPlusServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testGetCount(){
        long count = userService.count();
        System.out.println("总记录数目：" + count);
    }

    @Test
    public void testSaveBatch(){
        /**
         * @Description:sql长度有限制，海量数据存入，单条sql无法执行
         * 因此mp把批量插入放在了通用service中实现，而不是通用mapper
         * @Author: wlb
         * @Date: 2022/7/26 10:38
         * @param
         * @return:void
         */
        ArrayList<User> users = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            User user = new User();
            user.setName("ybc" + i);
            user.setAge(20 + i);
            users.add(user);
        }
        userService.saveBatch(users);
    }
}
