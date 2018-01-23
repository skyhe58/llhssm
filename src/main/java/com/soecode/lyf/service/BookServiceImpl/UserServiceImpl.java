package com.soecode.lyf.service.BookServiceImpl;

import com.soecode.lyf.dao.UserDao;
import com.soecode.lyf.entity.User;
import com.soecode.lyf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by llh on 2018-01-23 11:12
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List selectByUsernameAndPassword(User user) {
        return userDao.selectByUsernameAndPassword(user);
    }
}
