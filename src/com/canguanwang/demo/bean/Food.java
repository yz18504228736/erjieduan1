package com.canguanwang.demo.bean;

import java.math.BigDecimal;

public class Food {
    private Integer food_id;
    private Integer type_id;
    private String food_name;
    private BigDecimal food_price;
    private BigDecimal food_mprice;
    private String food_image;
    private String food_desc;

    public Integer getFood_id() {
        return food_id;
    }

    public void setFood_id(Integer food_id) {
        this.food_id = food_id;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public BigDecimal getFood_price() {
        return food_price;
    }

    public void setFood_price(BigDecimal food_price) {
        this.food_price = food_price;
    }

    public BigDecimal getFood_mprice() {
        return food_mprice;
    }

    public void setFood_mprice(BigDecimal food_mprice) {
        this.food_mprice = food_mprice;
    }

    public String getFood_image() {
        return food_image;
    }

    public void setFood_image(String food_image) {
        this.food_image = food_image;
    }

    public String getFood_desc() {
        return food_desc;
    }

    public void setFood_desc(String food_desc) {
        this.food_desc = food_desc;
    }

    @Override
    public String toString() {
        return "Food{" +
                "food_id=" + food_id +
                ", type_id=" + type_id +
                ", food_name='" + food_name + '\'' +
                ", food_price=" + food_price +
                ", food_mprice=" + food_mprice +
                ", food_image='" + food_image + '\'' +
                ", food_desc='" + food_desc + '\'' +
                '}';

    }
}
