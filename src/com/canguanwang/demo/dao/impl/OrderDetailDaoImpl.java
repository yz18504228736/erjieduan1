package com.canguanwang.demo.dao.impl;

import com.canguanwang.demo.bean.Order;
import com.canguanwang.demo.bean.OrderDetail;
import com.canguanwang.demo.dao.OrderDetailDao;
import com.canguanwang.demo.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class OrderDetailDaoImpl implements OrderDetailDao {
    QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
    @Override
    public int insertOrderDetail(OrderDetail detail) throws SQLException {
        String sql = "insert into t_order_detail (order_detail_id,order_id, food_id, num, food_total_price)" +
                "value (?,?,?,?,?)";
        int update = qr.update(sql, detail.getOrder_detail_id(), detail.getOrder_id(), detail.getFood_id(), detail.getNum(), detail.getFood_total_price());
        return update;
    }

    @Override
    public List<OrderDetail> selectOrderDetailByOrderId(String orderId) throws SQLException {
        String sql = "select * from t_order_detail where order_id = ?";
        List<OrderDetail> query = qr.query(sql, new BeanListHandler<OrderDetail>(OrderDetail.class), orderId);
        return query;
    }
}
