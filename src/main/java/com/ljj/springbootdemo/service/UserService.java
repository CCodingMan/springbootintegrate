package com.ljj.springbootdemo.service;

import com.ljj.springbootdemo.entity.User;

import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2019/2/11 15:43
 * @Description:用户服务接口
 */
public interface UserService {
    int addUser(User user);

    User findUserById(Integer id);

    int insertUser(String username, String password, int age);

    User selectById(int id);
}
