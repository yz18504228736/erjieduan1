package com.canguanwang.demo.service;

import com.canguanwang.demo.bean.Food;

import java.sql.SQLException;
import java.util.List;

public interface FoodService {
    List<Food> getAllFoods(String foodName) throws SQLException;

    int addFood(Food food) throws SQLException;

    int updateFoodSelective(Food food) throws SQLException;

    int deleteById(Integer id) throws SQLException;

    Food getFoodById(Integer foodId) throws SQLException;

    List<Food> getFoodByPage(int pageNum, Integer foodType) throws SQLException;

    int getFoodCount(Integer foodType) throws SQLException;

    List<Food> getFoodByPage(int pageNum, Integer typeIdd, String foodNameStr) throws SQLException;

    long getFoodCount(Integer typeIdd, String foodNameStr) throws SQLException;
}
