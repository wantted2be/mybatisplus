package com.company.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.company.mybatisplus.mapper.UserMapper;
import com.company.mybatisplus.pojo.User;
import com.company.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @Author wlb10
 * @PackageName mybatisplus
 * @Package com.company.mybatisplus
 * @Date 2022/7/26 18:56
 * @Version 1.0
 */
@SpringBootTest
public class MyBatisPlusWrapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01(){
        /**
         * @Description:查询用户名包含a，年龄在20到30之间，并且邮箱不为null的用户信息
         * @Author: wlb
         * @Date: 2022/7/26 19:04
         * @param
         * @return:void
         */
        QueryWrapper<User> queryMapper = new QueryWrapper<>();
        queryMapper.like("name","a").between("age",20,30).isNotNull("email");
        List<User> list = userMapper.selectList(queryMapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test02(){
        /**
         * @Description:按年龄降序查询用户，如果年龄相同则按id升序排列
         * @Author: wlb
         * @Date: 2022/7/26 19:28
         * @param
         * @return:void
         */
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age").orderByAsc("id");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test03(){
        /**
         * @Description:删除email为空的用户,逻辑删除
         * @Author: wlb
         * @Date: 2022/7/26 19:31
         * @param
         * @return:void
         */
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int delete = userMapper.delete(queryWrapper);
        System.out.println("受影响的行数：" + delete);
    }
    
    @Test
    public void test04(){
        /**
         * @Description:将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
         * @Author: wlb
         * @Date: 2022/7/26 19:39
         * @param
         * @return:void
         */
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","a").gt("age",20).or().isNull("email");
        User user = new User();
        user.setAge(18);
        user.setEmail("user@company.com");
        int update = userMapper.update(user, queryWrapper);
        System.out.println("受影响的行数：" + update);
    }

    @Test
    public void test04_2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        // UPDATE t_user SET age=?, email=? WHERE (username LIKE ? AND (age > ? OR email IS NULL))
        // lambda表达式内的逻辑优先运算
        queryWrapper.like("name", "a") .and(i -> i.gt("age", 20).or().isNull("email"));
        User user = new User();
        user.setAge(18);
        user.setEmail("user@atguigu.com");
        int result = userMapper.update(user, queryWrapper);
        System.out.println("受影响的行数：" + result);
    }

    @Test
    public void test05(){
        //查询用户信息的username和age字段
        // SELECT username,age FROM t_user
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","age");
        List<Map<String, Object>> mapList = userMapper.selectMaps(queryWrapper);
        mapList.forEach(System.out::println);
    }

    @Test
    public void test06(){
        //查询id小于等于3的用户信息
        // SELECT id,username AS name,age,email,is_deleted FROM t_user WHERE (id IN (select id from t_user where id <= 3))
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("uid", "select uid from t_user where uid <= 3 ");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test07(){
        //将（年龄大于20或邮箱为null）并且用户名中包含有a的用户信息修改
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("age",18).set("email","user@ATguigu.com").like("name","a").and(i -> i.gt("age",15).or().isNull("email"));
        int result = userMapper.update(null, updateWrapper);
        System.out.println(result);
    }

    @Test public void test08() {
        //定义查询条件，有可能为null（用户未输入或未选择）
        String username = null;
        Integer ageBegin = 10;
        Integer ageEnd = 24;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //StringUtils.isNotBlank()判断某字符串是否不为空且长度不为0且不由空白符(whitespace) 构成
        if(StringUtils.isNotBlank(username)){
            queryWrapper.like("name","a");
        }
        if(ageBegin != null){
            queryWrapper.ge("age", ageBegin);
        }
        if(ageEnd != null){
            queryWrapper.le("age", ageEnd);
        }
        //SELECT id,username AS name,age,email,is_deleted FROM t_user WHERE (age >= ? AND age <= ?)
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test public void test08UseCondition() {
        //定义查询条件，有可能为null（用户未输入或未选择）
        String username = null;
        Integer ageBegin = 10;
        Integer ageEnd = 24;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //StringUtils.isNotBlank()判断某字符串是否不为空且长度不为0且不由空白符(whitespace) 构成
        queryWrapper.like(StringUtils.isNotBlank(username), "name", "a").ge(ageBegin != null, "age", ageBegin) .le(ageEnd != null, "age", ageEnd);
        //SELECT id,username AS name,age,email,is_deleted FROM t_user WHERE (age >= ? AND age <= ?)
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test09() {
        //定义查询条件，有可能为null（用户未输入）
        String username = "a";
        Integer ageBegin = 10;
        Integer ageEnd = 24;
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //避免使用字符串表示字段，防止运行时错误
        queryWrapper .like(StringUtils.isNotBlank(username), User::getName, username) .ge(ageBegin != null, User::getAge, ageBegin) .le(ageEnd != null, User::getAge, ageEnd);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test public void test10() {
        //组装set子句
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper .set(User::getAge, 18) .set(User::getEmail, "user@atguigu.com") .like(User::getName, "a") .and(i -> i.lt(User::getAge, 24).or().isNull(User::getEmail));
        //lambda 表达式内的逻辑优先运算
        User user = new User();
        int result = userMapper.update(user, updateWrapper);
        System.out.println("受影响的行数：" + result);
    }
}
