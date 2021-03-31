package com.canguanwang.demo.dao.impl;

import com.canguanwang.demo.bean.User;
import com.canguanwang.demo.dao.UserDao;
import com.canguanwang.demo.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
    /**
     * 用户注册时添加
     *
     * @param user
     * @return
     * @throws SQLException
     */
    @Override
    public int insertUser(User user) throws SQLException {
        return 0;
    }

    /**
     * 登录
     *
     * @param name
     * @param password
     * @return
     */
    //dao层查询数据库,判断用户名,密码是否正确
    @Override
    public User selectUserByNameAndPwd(String name, String password) throws SQLException {
        String sql = "select * from t_user where username = ? and password = ?";
        User query = qr.query(sql, new BeanHandler<User>(User.class), name, password);
        return query;
    }
}
