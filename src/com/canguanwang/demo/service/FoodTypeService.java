package com.canguanwang.demo.service;

import com.canguanwang.demo.bean.FoodType;

import java.sql.SQLException;
import java.util.List;

public interface FoodTypeService {
    List<FoodType> getAllFoodTypes(String typeName) throws SQLException;

    int addFoodType(FoodType foodType) throws SQLException;

    int deleteById(Integer id) throws SQLException;

    int updateFoodTypeSelective(FoodType foodType) throws SQLException;

    FoodType getFoodTypeById(Integer typeId) throws SQLException;
}
