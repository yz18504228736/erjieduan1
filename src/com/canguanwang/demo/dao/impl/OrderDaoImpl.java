package com.canguanwang.demo.dao.impl;

import com.canguanwang.demo.bean.Order;
import com.canguanwang.demo.dao.OrderDao;
import com.canguanwang.demo.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());

    //    查询所有订单
    @Override
    public List<Order> selectAllOrders(String orderName) throws SQLException {
        String sql = "select * from t_order where order_id like ?";
        List<Order> query = qr.query(sql, new BeanListHandler<Order>(Order.class), "%" + orderName + "%");
        return query;
    }

    //    修改订单
    @Override
    public int updateOrderSelective(Order order) throws SQLException {
        String sql = "update t_order set ";
        List<Object> params = new ArrayList<>();
        if (order.getTable_id() != null) {
            sql += "table_id = ?, ";
            params.add(order.getTable_id());
        }
        if (order.getUser_id() != null) {
            sql += "user_id = ?, ";
            params.add(order.getUser_id());
        }
        if (order.getTotal_num() != null) {
            sql += "total_num = ?, ";
            params.add(order.getTotal_num());
        }
        if (order.getOrder_total_price() != null) {
            sql += "order_total_price = ?, ";
            params.add(order.getOrder_total_price());
        }
        if (order.getOrder_create_time() != null) {
            sql += "order_create_time = ?, ";
            params.add(order.getOrder_create_time());
        }
        if (order.getOrder_status() != null) {
            sql += "order_status = ?, ";
            params.add(order.getOrder_status());
        }
        sql = sql.substring(0, sql.lastIndexOf(","));
        sql += " where order_id = ?";
        params.add(order.getOrder_id());
        int update = qr.update(sql, params.toArray());
        return update;
    }

    //    删除订单
    @Override
    public int deleteById(String id) throws SQLException {
        String sql = "delete from t_order where order_id = ?";
        int update = qr.update(sql, id);
        return update;
    }

    //    根据id查询订单
    @Override
    public Order selectOrderById(String orderId) throws SQLException {
        String sql = "select * from t_order where order_id = ?";
        Order query = qr.query(sql, new BeanHandler<Order>(Order.class), orderId);
        return query;
    }

    //    新增订单
    @Override
    public int insertOrder(Order order) throws SQLException {
        String sql = "insert into t_order (order_id, table_id, user_id, total_num, order_total_price," +
                "order_create_time, order_status) value (?, ?, ?, ?, ?, ?, ?)";
        int update = qr.update(sql, order.getOrder_id(), order.getTable_id(), order.getUser_id(), order.getTotal_num(),
                order.getOrder_total_price(), order.getOrder_create_time(), order.getOrder_status());
        return update;
    }
}
