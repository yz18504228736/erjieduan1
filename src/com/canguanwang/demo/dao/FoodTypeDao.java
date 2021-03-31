package com.canguanwang.demo.dao;

import com.canguanwang.demo.bean.FoodType;

import java.sql.SQLException;
import java.util.List;

public interface FoodTypeDao {
    List<FoodType> selectAllFoodTypes(String typeName) throws SQLException;

    int insertFoodType(FoodType foodType) throws SQLException;

    int deleteById(Integer id) throws SQLException;

    int updateFoodTypeSelective(FoodType foodType) throws SQLException;

    FoodType selectFoodTypeById(Integer typeId) throws SQLException;
}
