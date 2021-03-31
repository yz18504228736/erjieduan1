package com.canguanwang.demo.bean;

import java.util.Date;

public class DinnerTable {
    private Integer table_id;
    private String table_name;
    private Integer table_status;
    private Date reservation_time;

    public Integer getTable_id() {
        return table_id;
    }

    public void setTable_id(Integer table_id) {
        this.table_id = table_id;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public Integer getTable_status() {
        return table_status;
    }

    public void setTable_status(Integer table_status) {
        this.table_status = table_status;
    }

    public Date getReservation_time() {
        return reservation_time;
    }

    public void setReservation_time(Date reservation_time) {
        this.reservation_time = reservation_time;
    }


    @Override
    public String toString() {
        return "DinnerTable{" +
                "table_id=" + table_id +
                ", table_name='" + table_name + '\'' +
                ", table_status=" + table_status +
                ", reservation_time=" + reservation_time +
                '}';

    }
}
