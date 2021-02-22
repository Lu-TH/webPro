package com.company.dao;

import com.company.entity.Manager;

import java.sql.*;

public class ManagerDaoImpl implements ManagerDao{
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static final String URL = "jdbc:mysql://localhost:3306/supermarket";
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static Connection connection;
    static{
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public String selectPwd(String mid) throws SQLException {
        String sql = " select mpwd from manager where mid = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, mid);
        ResultSet rs = ps.executeQuery();
        String truePwd = "";
        while(rs.next()){
            truePwd = rs.getString("mpwd");
        }
        return truePwd;
    }

    @Override
    public void insert(Manager manager) throws SQLException {
        String sql = " insert into manager values (?, ?, ?) ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, manager.getMid());
        ps.setString(2, manager.getMname());
        ps.setString(3, manager.getMpwd());
        ps.execute();
    }
}
