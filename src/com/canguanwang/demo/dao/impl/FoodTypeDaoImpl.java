package com.canguanwang.demo.dao.impl;

import com.canguanwang.demo.bean.FoodType;
import com.canguanwang.demo.dao.FoodTypeDao;
import com.canguanwang.demo.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class FoodTypeDaoImpl implements FoodTypeDao {
    private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());

    //    查询所有菜系
    @Override
    public List<FoodType> selectAllFoodTypes(String typeName) throws SQLException {
        String sql = "select * from t_food_type where type_name like ?";
        List<FoodType> foodTypes = qr.query(sql, new BeanListHandler<FoodType>(FoodType.class), "%" + typeName + "%");
        return foodTypes;
    }

    //    新增菜系
    @Override
    public int insertFoodType(FoodType foodType) throws SQLException {
        String sql = "insert into t_food_type (type_id, type_name) value (?,?)";
        return qr.update(sql, foodType.getType_id(), foodType.getType_name());
    }

    //    删除菜系
    @Override
    public int deleteById(Integer id) throws SQLException {
        String sql = "delete from t_food_type where type_id = ?";
        return qr.update(sql, id);
    }

    //    修改菜系
    @Override
    public int updateFoodTypeSelective(FoodType foodType) throws SQLException {
        String sql = "update t_food_type set type_name = ? where type_id = ?";
        int update = qr.update(sql, foodType.getType_name(), foodType.getType_id());
        return update;
    }

    //    根据id查询菜系
    @Override
    public FoodType selectFoodTypeById(Integer typeId) throws SQLException {
        String sql = "select * from t_food_type where type_id = ?";
        FoodType foodType = qr.query(sql, new BeanHandler<FoodType>(FoodType.class), typeId);
        return foodType;
    }
}
