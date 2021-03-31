package com.canguanwang.demo.service.impl;

import com.canguanwang.demo.bean.User;
import com.canguanwang.demo.dao.UserDao;
import com.canguanwang.demo.dao.impl.UserDaoImpl;
import com.canguanwang.demo.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    //    登录,获得用户的用户名和密码
    @Override
    public User getUserByNameAndPwd(String name, String password) throws SQLException {
        User user = userDao.selectUserByNameAndPwd(name, password);
        return user;
    }
}
