package com.soecode.lyf.service.impl;

import com.soecode.lyf.BaseTest;
import com.soecode.lyf.entity.User;
import com.soecode.lyf.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by llh on 2018-01-19 17:25
 */
public class UserTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
   public void login(){
        User user = new User();
        user.setUsername("aa");
        user.setPassword("a111111");
        List list = userService.selectByUsernameAndPassword(user);
        System.out.println("======="+list);
    }
}
