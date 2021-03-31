package com.canguanwang.demo.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private String order_id;
    private Integer table_id;
    private Integer user_id;
    private Integer total_num;
    private BigDecimal order_total_price;
    private Date order_create_time;
    private Integer order_status;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Integer getTable_id() {
        return table_id;
    }

    public void setTable_id(Integer table_id) {
        this.table_id = table_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getTotal_num() {
        return total_num;
    }

    public void setTotal_num(Integer total_num) {
        this.total_num = total_num;
    }

    public BigDecimal getOrder_total_price() {
        return order_total_price;
    }

    public void setOrder_total_price(BigDecimal order_total_price) {
        this.order_total_price = order_total_price;
    }

    public Date getOrder_create_time() {
        return order_create_time;
    }

    public void setOrder_create_time(Date order_create_time) {
        this.order_create_time = order_create_time;
    }

    public Integer getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Integer order_status) {
        this.order_status = order_status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id='" + order_id + '\'' +
                ", table_id=" + table_id +
                ", user_id=" + user_id +
                ", total_num=" + total_num +
                ", order_total_price=" + order_total_price +
                ", order_create_time=" + order_create_time +
                ", order_status=" + order_status +
                '}';

    }
}
