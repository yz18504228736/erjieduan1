package com.canguanwang.demo.dao;

import com.canguanwang.demo.bean.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderDao {
    List<Order> selectAllOrders(String orderName) throws SQLException;

    int updateOrderSelective(Order order) throws SQLException;

    int deleteById(String id) throws SQLException;

    Order selectOrderById(String orderId) throws SQLException;

    int insertOrder(Order order) throws SQLException;
}
