package com.canguanwang.demo.service.impl;

import com.canguanwang.demo.bean.Order;
import com.canguanwang.demo.dao.OrderDao;
import com.canguanwang.demo.dao.impl.OrderDaoImpl;
import com.canguanwang.demo.service.OrderService;

import java.sql.SQLException;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();

    //    查询所有订单
    @Override
    public List<Order> getAllOrders(String orderName) throws SQLException {
        return orderDao.selectAllOrders(orderName);
    }

    //    修改订单
    @Override
    public int updateOrderSelective(Order order) throws SQLException {
        return orderDao.updateOrderSelective(order);
    }

    //    删除订单
    @Override
    public int deleteById(String id) throws SQLException {
        return orderDao.deleteById(id);
    }

    //    根据id查询订单
    @Override
    public Order getOrderById(String orderId) throws SQLException {
        return orderDao.selectOrderById(orderId);
    }

    //    新增订单
    @Override
    public int addOrder(Order order) throws SQLException {
        return orderDao.insertOrder(order);
    }
}
