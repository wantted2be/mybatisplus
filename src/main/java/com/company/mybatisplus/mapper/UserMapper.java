package com.company.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.company.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @Author wlb10
 * @PackageName mybatisplus
 * @Package com.company.mybatisplus.mapper
 * @Date 2022/7/25 21:48
 * @Version 1.0
 */
@Repository  //将类或者接口标识为持久层组件
public interface UserMapper extends BaseMapper<User> {
    /**
     * @Description:根据id查询用户信息为map集合
     * @Author: wlb
     * @Date: 2022/7/26 10:14
     * @param id
     * @return:java.util.Map<java.lang.String,java.lang.Object>
     */
    Map<String,Object> selectMapById(Long id);

    /**
     * @Description:根据年龄查询用户列表，分页显示,注意此时配置的逻辑删除功能失效
     * @Author: wlb
     * @Date: 2022/7/27 7:09
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位
     * @param age
     * @return:com.baomidou.mybatisplus.extension.plugins.pagination.Page<com.company.mybatisplus.pojo.User>
     */
    Page<User> selectPageVo(@Param("page") Page<User> page, @Param("age") Integer age);
}
