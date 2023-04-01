package com.example.a.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.a.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from demo.ACC where 账户名 = #{name}")
    User findByName(@Param("name") String name);

    @Insert("insert into demo.ACC (账户名, 密码, 权限) values(#{name}, #{password}, #{auth})")
    void insertOne(User user);


}
