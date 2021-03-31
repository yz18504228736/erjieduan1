package com.canguanwang.demo.bean;

import java.math.BigDecimal;

public class OrderDetail {
    private String order_detail_id;
    private String order_id;
    private Integer food_id;
    private Integer num;
    private BigDecimal food_total_price;

    public String getOrder_detail_id() {
        return order_detail_id;
    }

    public void setOrder_detail_id(String order_detail_id) {
        this.order_detail_id = order_detail_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Integer getFood_id() {
        return food_id;
    }

    public void setFood_id(Integer food_id) {
        this.food_id = food_id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getFood_total_price() {
        return food_total_price;
    }

    public void setFood_total_price(BigDecimal food_total_price) {
        this.food_total_price = food_total_price;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "order_detail_id=" + order_detail_id +
                ", order_id='" + order_id + '\'' +
                ", food_id=" + food_id +
                ", num=" + num +
                ", food_total_price=" + food_total_price +
                '}';

    }
}
