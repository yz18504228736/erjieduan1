package com.canguanwang.demo.dao;

import com.canguanwang.demo.utils.JdbcUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcTest {
    public static void main(String[] args) {
        DataSource dataSource = JdbcUtils.getDataSource();
        System.out.println(dataSource);
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(connection);

    }
}
