package com.company.mybatisplus;

import com.company.mybatisplus.enums.SexEnum;
import com.company.mybatisplus.mapper.UserMapper;
import com.company.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author wlb10
 * @PackageName mybatisplus
 * @Package com.company.mybatisplus
 * @Date 2022/7/27 8:49
 * @Version 1.0
 */
@SpringBootTest
public class MyBatisPlusEnumTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSexEnum(){
        User user = new User();
        user.setName("Enum");
        user.setAge(20);
        //设置性别信息为枚举项，会将@EnumValue注解所标识的属性值存储到数据库
        user.setSex(SexEnum.MALE);
        int insert = userMapper.insert(user);
        System.out.println("受影响的行数：" + insert);
    }
}
