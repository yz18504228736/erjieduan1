package com.canguanwang.demo.service.impl;

import com.canguanwang.demo.bean.Food;
import com.canguanwang.demo.dao.FoodDao;
import com.canguanwang.demo.dao.impl.FoodDaoImpl;
import com.canguanwang.demo.service.FoodService;

import java.sql.SQLException;
import java.util.List;

public class FoodServiceImpl implements FoodService {
    private FoodDao foodDao = new FoodDaoImpl();

    //    查询所有菜品
    @Override
    public List<Food> getAllFoods(String foodName) throws SQLException {
        return foodDao.selectAllFoods(foodName);
    }

    //    新增菜品
    @Override
    public int addFood(Food food) throws SQLException {
        return foodDao.insertFood(food);
    }

    //    修改菜品
    @Override
    public int updateFoodSelective(Food food) throws SQLException {
        return foodDao.updateFoodSelective(food);
    }

    //    删除菜品
    @Override
    public int deleteById(Integer id) throws SQLException {
        return foodDao.deleteById(id);
    }

    //    根据id查询菜品
    @Override
    public Food getFoodById(Integer foodId) throws SQLException {
        return foodDao.selectFoodById(foodId);
    }


    @Override
    public List<Food> getFoodByPage(int pageNum, Integer foodType) throws SQLException {
        return foodDao.selectFoodByPage(pageNum, foodType);
    }

    @Override
    public int getFoodCount(Integer foodType) throws SQLException {
        return foodDao.selectFoodCount(foodType);
    }

    @Override
    public List<Food> getFoodByPage(int pageNum, Integer typeIdd, String foodNameStr) throws SQLException {
        return foodDao.selectFoodByPage(pageNum, typeIdd,foodNameStr);
    }

    @Override
    public long getFoodCount(Integer typeIdd, String foodNameStr) throws SQLException {
        return foodDao.selectFoodCount(typeIdd, foodNameStr);
    }
}
