package com.canguanwang.demo.dao;

import com.canguanwang.demo.bean.OrderDetail;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailDao {
    int insertOrderDetail(OrderDetail detail) throws SQLException;

    List<OrderDetail> selectOrderDetailByOrderId(String orderId) throws SQLException;
}
