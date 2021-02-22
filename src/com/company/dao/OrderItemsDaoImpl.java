package com.company.dao;

import com.company.entity.OrderItems;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderItemsDaoImpl implements OrderItemsDao{
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
    public void insert(OrderItems orderItems) throws SQLException {
        String sql = " insert into order_items values (?, ?, ?) ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, orderItems.getFk_oid());
        ps.setString(2, orderItems.getFk_pid());
        ps.setInt(3, orderItems.getQuantity());
        ps.execute();
    }

    @Override
    public void update(OrderItems orderItems) throws SQLException {//修改订单
        String sql = " update order_items set quantity = ? where fk_oid = ? and fk_pid = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, orderItems.getQuantity());
        ps.setInt(2, orderItems.getFk_oid());
        ps.setString(3, orderItems.getFk_pid());
        ps.execute();
    }

    @Override
    public void delete(String fk_oid) throws SQLException {
        String sql = " delete from order_items where fk_oid = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, fk_oid);
        ps.execute();
    }

    @Override
    public void delByPid(String fk_pid) throws SQLException {
        String sql = " delete from order_items where fk_pid = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, fk_pid);
        ps.execute();
    }

}
