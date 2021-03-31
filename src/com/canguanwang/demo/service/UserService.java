package com.canguanwang.demo.service;

import com.canguanwang.demo.bean.User;

import java.sql.SQLException;

public interface UserService {
    User getUserByNameAndPwd(String name, String password) throws SQLException;
}
