package com.canguanwang.demo.dao.impl;

import com.canguanwang.demo.bean.DinnerTable;
import com.canguanwang.demo.dao.DinnerTableDao;
import com.canguanwang.demo.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DinnerTableDaoImpl implements DinnerTableDao {
    private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());


    //  模糊查询,根据传入的值查询餐桌的名字
    @Override
    public List<DinnerTable> selectAllDinnerTables(String tableName) throws SQLException {
        String sql = "select * from t_dinner_table where table_name like ?";
        List<DinnerTable> dinnerTables = qr.query(sql, new BeanListHandler<DinnerTable>(DinnerTable.class), "%"+tableName+"%");
        return dinnerTables;
    }

    //    添加餐桌信息
    @Override
    public int insertDinnerTable(DinnerTable dinnerTable) throws SQLException {
        String sql = "insert into t_dinner_table (table_id, table_name, table_status, reservation_time) value (?,?,?,?)";
        int res = qr.update(sql, null, dinnerTable.getTable_name(), dinnerTable.getTable_status(), dinnerTable.getReservation_time());
        return res;
    }

    //    修改餐桌信息
    @Override
    public int updateDinnerTable(DinnerTable updateDinnerTb) throws SQLException {
        String sql = "update t_dinner_table ";
        List<Object> param = new ArrayList<>();
        if (updateDinnerTb.getTable_name() != null) {
            sql += "set table_name = ?,";
            param.add(updateDinnerTb.getTable_name());
        }
        if (updateDinnerTb.getTable_status() != null) {
            sql += "set table_status = ?,";
            param.add(updateDinnerTb.getTable_status());
        }
        if (updateDinnerTb.getReservation_time() != null) {
            sql += "set reservation_time = ?,";
            param.add(updateDinnerTb.getReservation_time());
        }
        sql = sql.substring(0, sql.lastIndexOf(","));
        sql += " where table_id = ?";
        param.add(updateDinnerTb.getTable_id());
        Object[] objects = param.toArray();
        int update = qr.update(sql, objects);
        return update;
    }

    //    根据id删除餐桌信息
    @Override
    public int deleteById(Integer id) throws SQLException {
        String sql = "delete from t_dinner_table where table_id = ?";
        int delete = qr.update(sql, id);
        return delete;
    }

    /**
     * 获取空闲桌子
     *
     * @return
     */
    @Override
    public List<DinnerTable> selectEmptyDinnerTables() throws SQLException {
        String sql = "select * from t_dinner_table where table_status = 0";
        List<DinnerTable> query = qr.query(sql, new BeanListHandler<DinnerTable>(DinnerTable.class));
        return query;
    }
}
