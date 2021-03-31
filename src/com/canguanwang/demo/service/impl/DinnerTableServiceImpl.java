package com.canguanwang.demo.service.impl;

import com.canguanwang.demo.bean.DinnerTable;
import com.canguanwang.demo.dao.DinnerTableDao;
import com.canguanwang.demo.dao.impl.DinnerTableDaoImpl;
import com.canguanwang.demo.service.DinnerTableService;

import java.sql.SQLException;
import java.util.List;

public class DinnerTableServiceImpl implements DinnerTableService {
    private DinnerTableDao dinnerTableDao = new DinnerTableDaoImpl();

    //    查询餐桌
    @Override
    public List<DinnerTable> getAllDinnerTables(String tableName) throws SQLException {
        return dinnerTableDao.selectAllDinnerTables(tableName);
    }

    //    新增餐桌
    @Override
    public int addDinnerTable(DinnerTable dinnerTable) throws SQLException {
        return dinnerTableDao.insertDinnerTable(dinnerTable);
    }

    //    修改餐桌信息
    @Override
    public int updateDinnerTableSelective(DinnerTable updateDinnerTb) throws SQLException {
        return dinnerTableDao.updateDinnerTable(updateDinnerTb);
    }

    //    根据id删除餐桌
    @Override
    public int deleteById(Integer id) throws SQLException {
        return dinnerTableDao.deleteById(id);
    }

    //    获取空闲桌子
    @Override
    public List<DinnerTable> getEmptyDinnerTables() throws SQLException {
        return dinnerTableDao.selectEmptyDinnerTables();
    }
}
