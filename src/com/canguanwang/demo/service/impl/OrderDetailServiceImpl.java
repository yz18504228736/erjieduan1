package com.canguanwang.demo.service.impl;

import com.canguanwang.demo.bean.OrderDetail;
import com.canguanwang.demo.dao.OrderDetailDao;
import com.canguanwang.demo.dao.impl.OrderDetailDaoImpl;
import com.canguanwang.demo.service.OrderDetailService;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailServiceImpl implements OrderDetailService {
    private OrderDetailDao orderDetailDao = new OrderDetailDaoImpl();

    @Override
    public int addOrderDetail(OrderDetail detail) throws SQLException {
        return orderDetailDao.insertOrderDetail(detail);
    }

    @Override
    public List<OrderDetail> getOrderDetailByOrderId(String orderId) throws SQLException {
        return orderDetailDao.selectOrderDetailByOrderId(orderId);
    }
}
