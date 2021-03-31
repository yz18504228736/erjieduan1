package com.canguanwang.demo.dao;

import com.canguanwang.demo.bean.Food;

import java.sql.SQLException;
import java.util.List;

public interface FoodDao {
    List<Food> selectAllFoods(String foodName) throws SQLException;

    int insertFood(Food food) throws SQLException;

    int updateFoodSelective(Food food) throws SQLException;

    int deleteById(Integer id) throws SQLException;

    Food selectFoodById(Integer foodId) throws SQLException;

    List<Food> selectFoodByPage(int pageNum, Integer foodType) throws SQLException;

    int selectFoodCount(Integer foodType) throws SQLException;

    List<Food> selectFoodByPage(int pageNum, Integer typeIdd, String foodNameStr) throws SQLException;

    long selectFoodCount(Integer typeIdd, String foodNameStr) throws SQLException;
}
