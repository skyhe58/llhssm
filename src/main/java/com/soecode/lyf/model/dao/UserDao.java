package com.soecode.lyf.model.dao;

import com.soecode.lyf.entity.User;

import java.util.List;

/**
 * Created by llh on 2018-01-23 11:09
 */
public interface UserDao {

    List selectByUsernameAndPassword(User user);
}
