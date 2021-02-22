package com.company.dao;

import com.company.entity.Manager;

import java.sql.SQLException;

public interface ManagerDao {
    public String selectPwd(String mid) throws SQLException;//查找管理员登录密码
    public void insert(Manager manager) throws SQLException;//管理员注册
}
