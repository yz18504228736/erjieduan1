package com.canguanwang.demo.dao;

import com.canguanwang.demo.bean.DinnerTable;

import java.sql.SQLException;
import java.util.List;

public interface DinnerTableDao {
    List<DinnerTable> selectAllDinnerTables(String tableName) throws SQLException;

    int insertDinnerTable(DinnerTable dinnerTable) throws SQLException;

    int updateDinnerTable(DinnerTable updateDinnerTb) throws SQLException;

    int deleteById(Integer id) throws SQLException;

    /**
     * 获取空闲桌子
     * @return
     */
    List<DinnerTable> selectEmptyDinnerTables() throws SQLException;
}
