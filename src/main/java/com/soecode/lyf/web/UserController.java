package com.soecode.lyf.web;

import com.soecode.lyf.entity.User;
import com.soecode.lyf.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * Created by llh on 2018-01-23 11:15
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    private String login(@RequestParam String username, @RequestParam String password,HttpSession session){

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        List list = userService.selectByUsernameAndPassword(user);
        session.setAttribute("username", user.getUsername());
        if(!list.isEmpty()){
            System.out.println("登录成功");
            return "redirect:/user/showSuccess";
        }
        System.out.println("重新登录");
        return "forward:/user/showLogin";
//        return "login";
    }


}
