package com.soecode.lyf.service;

import com.soecode.lyf.entity.User;

import java.util.List;

/**
 * Created by llh on 2018-01-23 11:11
 */
public interface UserService {

    List selectByUsernameAndPassword(User user);
}
