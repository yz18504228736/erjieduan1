package com.canguanwang.demo.service;

import com.canguanwang.demo.bean.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {
    List<Order> getAllOrders(String orderName) throws SQLException;

    int updateOrderSelective(Order order) throws SQLException;

    int deleteById(String id) throws SQLException;

    Order getOrderById(String orderId) throws SQLException;

    int addOrder(Order order) throws SQLException;
}
