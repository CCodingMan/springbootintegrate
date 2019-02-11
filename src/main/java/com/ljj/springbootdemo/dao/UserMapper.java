package com.ljj.springbootdemo.dao;

import com.ljj.springbootdemo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 使用mybatis sql语句注解则需要引入，@Mapper注解，详细请看当前接口的addUser()方法和findById()方法
 */
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Insert("insert into user(username, password, age) values(#{username}, #{password}, #{age})")
    int addUser(@Param("username") String username, @Param("password") String password, @Param("age") int age);

    @Select("select * from user where id = #{id}")
    User findById(@Param("id") int id);
}