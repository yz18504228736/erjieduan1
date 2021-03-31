package com.canguanwang.demo.service;

import com.canguanwang.demo.bean.DinnerTable;

import java.sql.SQLException;
import java.util.List;

public interface DinnerTableService {
    List<DinnerTable> getAllDinnerTables(String tableName) throws SQLException;

    int addDinnerTable(DinnerTable dinnerTable) throws SQLException;

    int updateDinnerTableSelective(DinnerTable updateDinnerTb) throws SQLException;

    int deleteById(Integer id) throws SQLException;

    List<DinnerTable> getEmptyDinnerTables() throws SQLException;
}
