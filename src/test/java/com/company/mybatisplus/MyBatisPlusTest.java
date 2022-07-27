package com.company.mybatisplus;

import com.company.mybatisplus.enums.SexEnum;
import com.company.mybatisplus.mapper.UserMapper;
import com.company.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wlb10
 * @PackageName mybatisplus
 * @Package com.company.mybatisplus
 * @Date 2022/7/25 21:52
 * @Version 1.0
 */
@SpringBootTest
public class MyBatisPlusTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectListExample(){
        //通过条件构造器查询一个list集合，若没有条件，则可以设置null为参数
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        User user = new User(null, "张三", 23, "zhangsan@atguigu.com", SexEnum.MALE,0);
        int result = userMapper.insert(user);
        System.out.println("添加的操作受影响的行数：" + result);
        System.out.println("id自动获取：" + user.getId());
    }

    @Test
    public void testDeleteById(){
        //末尾加上L表示long类型的数据
        int result = userMapper.deleteById(1551570450704830466L);
        System.out.println("删除操作受影响的行数：" + result);
    }

    @Test
    public void testDeleteByMap(){
        Map<String,Object> map = new HashMap<>();
        map.put("age",23);
        map.put("name", "张三");
        int result = userMapper.deleteByMap(map);
        System.out.println("map删除受影响的行数：" + result);
    }

    @Test
    public void testDeleteBatchIds(){
        List<Long> idList = Arrays.asList(4L, 5L, 8L);
        int result = userMapper.deleteBatchIds(idList);
        System.out.println("id批量删除受影响的行数：" + result);
    }

    //@Test
    public void testUpdateById(){
        User user = new User(4L, "admin", 22, null, null,0);
        int result = userMapper.updateById(user);
        System.out.println("修改函数受影响的行数：" + result);
    }

    @Test
    public void testSelectById(){
        User user = userMapper.selectById(4L);
        System.out.println("根据id查找用户信息：" + user);
    }

    @Test
    public void testSelectByIds(){
        List<Long> idList = Arrays.asList(4L, 5L);
        List<User> list = userMapper.selectBatchIds(idList);
        list.forEach(System.out::println);
    }

    @Test
    public void testSelectByMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("age", 22);
        map.put("name","admin");
        List<User> list = userMapper.selectByMap(map);
        list.forEach(System.out::println);
    }

    @Test
    public void testSelectList(){
        List<User> list = userMapper.selectList(null);
        list.forEach(System.out::println);
    }

    @Test
    public void testSelectMapById(){
        /**
         * @Description:测试自定义功能实现
         * @Author: wlb
         * @Date: 2022/7/26 10:19
         * @param
         * @return:void
         */
        Map<String, Object> map = userMapper.selectMapById(4L);
        System.out.println(map);
    }

}
