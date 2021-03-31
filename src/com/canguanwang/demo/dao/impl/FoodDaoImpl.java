package com.canguanwang.demo.dao.impl;

import com.canguanwang.demo.bean.Food;
import com.canguanwang.demo.dao.FoodDao;
import com.canguanwang.demo.utils.Constant;
import com.canguanwang.demo.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao {
    private QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());

    //  查询所有菜品
    @Override
    public List<Food> selectAllFoods(String foodName) throws SQLException {
        String sql = "select * from t_food where food_name like ?";
        List<Food> foodList = qr.query(sql, new BeanListHandler<Food>(Food.class), "%" + foodName + "%");
        return foodList;
    }

    //    新增菜品
    @Override
    public int insertFood(Food food) throws SQLException {
        String sql = "insert into t_food (food_id, type_id, food_name, food_price, food_mprice, food_image, food_desc) value (" +
                "?, ?, ?, ?, ?, ?, ?)";
        int update = qr.update(sql, food.getFood_id(), food.getType_id(), food.getFood_name(), food.getFood_price(), food.getFood_mprice(),
                food.getFood_image(), food.getFood_desc());
        return update;
    }

    //    修改菜品
    @Override
    public int updateFoodSelective(Food food) throws SQLException {
        String sql = "update t_food set ";
        List<Object> params = new ArrayList<>();
        if (food.getType_id() != null) {
            sql += "type_id = ?, ";
            params.add(food.getType_id());
        }
        if (food.getFood_name() != null) {
            sql += "food_name = ?, ";
            params.add(food.getFood_name());
        }
        if (food.getFood_price() != null) {
            sql += "food_price = ?, ";
            params.add(food.getFood_price());
        }
        if (food.getFood_mprice() != null) {
            sql += "food_mprice = ?, ";
            params.add(food.getFood_mprice());
        }
        if (food.getFood_image() != null) {
            sql += "food_image = ?, ";
            params.add(food.getFood_image());
        }
        if (food.getFood_desc() != null) {
            sql += "food_desc = ?, ";
            params.add(food.getFood_desc());
        }
        sql = sql.substring(0, sql.lastIndexOf(","));
        sql += " where food_id = ?";
        params.add(food.getFood_id());
        Object[] objects = params.toArray();
        int update = qr.update(sql, objects);
        return update;
    }

    //    删除菜品
    @Override
    public int deleteById(Integer id) throws SQLException {
        String sql = "delete from t_food where food_id = ?";
        int update = qr.update(sql, id);
        return update;
    }

    //    根据id查询菜品信息
    @Override
    public Food selectFoodById(Integer foodId) throws SQLException {
        String sql = "select * from t_food where food_id = ?";
        Food food = qr.query(sql, new BeanHandler<Food>(Food.class), foodId);
        return food;
    }

    @Override
    public List<Food> selectFoodByPage(int pageNum, Integer foodType) throws SQLException {
        String sql = "select * from t_food where 1=1 ";
        List<Object> params = new ArrayList<>();
        if (foodType != null) {
            sql += "and type_id = ? ";
            params.add(foodType);
        }
        sql += "limit ?, ?";
        params.add((pageNum-1)* Constant.PAGE_SIZE);
        params.add(Constant.PAGE_SIZE);
        List<Food> query = qr.query(sql, new BeanListHandler<Food>(Food.class), params.toArray());
        return query;
    }

    @Override
    public int selectFoodCount(Integer foodType) throws SQLException {
        String sql = "select count(*) from t_food where 1=1 ";
        List<Object> params = new ArrayList<>();
        if (foodType != null) {
            sql += "and type_id = ? ";
            params.add(foodType);
        }
        Integer count = qr.query(sql, new BeanHandler<Integer>(Integer.class), params.toArray());
        return count;
    }

    @Override
    public List<Food> selectFoodByPage(int pageNum, Integer typeIdd, String foodNameStr) throws SQLException {
        String sql = "select * from t_food where 1=1 ";
        List<Object> params = new ArrayList<>();
        if (typeIdd != null) {
            sql += "and type_id = ? ";
            params.add(typeIdd);
        }
        if (foodNameStr != null && !"".equals(foodNameStr)) {
            sql += "and food_name like ? ";
            params.add("%"+foodNameStr+"%");
        }
        sql += "limit ?, ?";
        params.add((pageNum-1)* Constant.PAGE_SIZE);
        params.add(Constant.PAGE_SIZE);
        List<Food> query = qr.query(sql, new BeanListHandler<Food>(Food.class), params.toArray());
        return query;
    }

    @Override
    public long selectFoodCount(Integer typeIdd, String foodNameStr) throws SQLException {
        String sql = "select count(*) from t_food where 1=1 ";
        List<Object> params = new ArrayList<>();
        if (typeIdd != null) {
            sql += "and type_id = ? ";
            params.add(typeIdd);
        }
        if (foodNameStr != null && !"".equals(foodNameStr)) {
            sql += "and food_name like ? ";
            params.add("%"+foodNameStr+"%");
        }
        long count = qr.query(sql, new ScalarHandler<Long>(), params.toArray());
        return count;
    }
}
