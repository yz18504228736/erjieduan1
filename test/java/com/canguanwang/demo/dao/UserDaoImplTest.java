package com.canguanwang.demo.dao;


import com.canguanwang.demo.bean.User;
import com.canguanwang.demo.dao.impl.UserDaoImpl;
import org.junit.Test;

import java.sql.SQLException;

public class UserDaoImplTest {
    private UserDao userDao = new UserDaoImpl();

    @Test
    public void selectUserByNameandPwdTest() throws SQLException {
        User user = userDao.selectUserByNameAndPwd("dengjie", "123456");
        System.out.println(user);
    }
}
