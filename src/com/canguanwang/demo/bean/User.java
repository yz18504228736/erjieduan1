package com.canguanwang.demo.bean;

import java.math.BigDecimal;
import java.util.Date;

public class User {
    private Integer user_id;
    private String username;
    private String password;
    private String nick_name;
    private Integer is_admin;
    private String phone;
    private Integer gender;
    private Integer user_status;
    private Date user_create_time;
    private Date user_update_time;
    private Integer is_delete;
    private Integer is_member;
    private BigDecimal balance;


    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public Integer getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(Integer is_admin) {
        this.is_admin = is_admin;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getUser_status() {
        return user_status;
    }

    public void setUser_status(Integer user_status) {
        this.user_status = user_status;
    }

    public Date getUser_create_time() {
        return user_create_time;
    }

    public void setUser_create_time(Date user_create_time) {
        this.user_create_time = user_create_time;
    }

    public Date getUser_update_time() {
        return user_update_time;
    }

    public void setUser_update_time(Date user_update_time) {
        this.user_update_time = user_update_time;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    public Integer getIs_member() {
        return is_member;
    }

    public void setIs_member(Integer is_member) {
        this.is_member = is_member;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", is_admin=" + is_admin +
                ", phone='" + phone + '\'' +
                ", gender=" + gender +
                ", user_status=" + user_status +
                ", user_create_time=" + user_create_time +
                ", user_update_time=" + user_update_time +
                ", is_delete=" + is_delete +
                ", is_member=" + is_member +
                ", balance=" + balance +
                '}';
    }
}
