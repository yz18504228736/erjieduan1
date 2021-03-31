package com.canguanwang.demo.dao;

import com.canguanwang.demo.bean.User;

import java.sql.SQLException;

public interface UserDao {
    /**
     * 用户注册时添加
     * @param user
     * @return
     * @throws SQLException
     */
    int insertUser(User user) throws SQLException;

    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    User selectUserByNameAndPwd(String name, String password) throws SQLException;
}
