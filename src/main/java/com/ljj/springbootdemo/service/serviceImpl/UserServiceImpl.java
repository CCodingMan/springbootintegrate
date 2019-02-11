package com.ljj.springbootdemo.service.serviceImpl;

import com.ljj.springbootdemo.dao.UserMapper;
import com.ljj.springbootdemo.entity.User;
import com.ljj.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: ljj
 * @Date: 2019/2/11 15:45
 * @Description:
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public int addUser(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public User findUserById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int insertUser(String username, String password, int age) {
        return userMapper.addUser(username, password, age);
    }

    @Override
    public User selectById(int id) {
        return userMapper.findById(id);
    }
}
