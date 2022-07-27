package com.company.mybatisx.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.company.mybatisx.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author wlb10
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2022-07-27 10:55:02
* @Entity com.company.mybatisx.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {
    int insertSelective(User user);

    int deleteByUidAndName(@Param("uid") Long uid, @Param("name") String name);

    int updateAgeAndSexByUid(@Param("age") Integer age, @Param("sex") Integer sex, @Param("uid") Long uid);

    List<User> selectAgeAndSexByAgeBetween(@Param("beginAge") Integer beginAge, @Param("endAge") Integer endAge);

    List<User> selectAllOrderByAgeDesc();
}




