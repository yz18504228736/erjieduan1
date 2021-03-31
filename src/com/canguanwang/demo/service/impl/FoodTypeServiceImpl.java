package com.canguanwang.demo.service.impl;

import com.canguanwang.demo.bean.FoodType;
import com.canguanwang.demo.dao.FoodTypeDao;
import com.canguanwang.demo.dao.impl.FoodTypeDaoImpl;
import com.canguanwang.demo.service.FoodTypeService;

import java.sql.SQLException;
import java.util.List;

public class FoodTypeServiceImpl implements FoodTypeService {
    private FoodTypeDao foodTypeDao = new FoodTypeDaoImpl();

    //    查询所有菜系
    @Override
    public List<FoodType> getAllFoodTypes(String typeName) throws SQLException {
        List<FoodType> foodTypes = foodTypeDao.selectAllFoodTypes(typeName);
        return foodTypes;
    }

    //    新增菜系
    @Override
    public int addFoodType(FoodType foodType) throws SQLException {
        return foodTypeDao.insertFoodType(foodType);
    }

    //    删除菜系
    @Override
    public int deleteById(Integer id) throws SQLException {
        return foodTypeDao.deleteById(id);
    }

    //    修改菜系
    @Override
    public int updateFoodTypeSelective(FoodType foodType) throws SQLException {
        return foodTypeDao.updateFoodTypeSelective(foodType);
    }

    //    根据id查询菜系
    @Override
    public FoodType getFoodTypeById(Integer typeId) throws SQLException {
        return foodTypeDao.selectFoodTypeById(typeId);
    }
}
