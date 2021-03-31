package com.canguanwang.demo.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Jdbc工具类
 * @author ghy
 * @version 1.0
 */
public class JdbcUtils {

    private static DataSource dataSource;

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    private static final Properties PROPERTIES = new Properties();

    static {
        try {
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            PROPERTIES.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(PROPERTIES);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = threadLocal.get();
            if(connection == null) {
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 开启事务
     */
    public static void begin(){
        try {
            getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public static void commit(){
        try {
            getConnection().commit();
            release(getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public static void rollback(){
        try {
            getConnection().rollback();
            release(getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     * @param connection
     */
    public static void release(Connection connection){
        try {
            if(connection != null) {
                connection.close();
                threadLocal.remove();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
