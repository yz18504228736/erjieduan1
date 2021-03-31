package com.canguanwang.demo.service;

import com.canguanwang.demo.bean.OrderDetail;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailService {
    int addOrderDetail(OrderDetail detail) throws SQLException;

    List<OrderDetail> getOrderDetailByOrderId(String orderId) throws SQLException;
}
