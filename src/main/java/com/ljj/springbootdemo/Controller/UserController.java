package com.ljj.springbootdemo.Controller;

import com.ljj.springbootdemo.entity.User;
import com.ljj.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Id;

/**
 * @Auther: ljj
 * @Date: 2019/2/11 11:29
 * @Description:用户控制类
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public User getUser(@RequestParam("id") int id){
        return userService.findUserById(id);
    }

    @RequestMapping("/addUser")
    public int addUser(@RequestParam("userName") String userName, @RequestParam("password") String password
            , @RequestParam("age") int age){
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        user.setAge(age);
        return userService.addUser(user);
    }

    @RequestMapping("/getUser2")
    public User getUser2(@RequestParam("id") int id){

        return userService.selectById(id);
    }

    @RequestMapping("/addUser2")
    public int addUser2(@RequestParam("userName") String userName, @RequestParam("password") String password
            , @RequestParam("age") int age){

        return userService.insertUser(userName, password, age);
    }
}
