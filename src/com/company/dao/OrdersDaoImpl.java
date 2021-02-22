package com.company.dao;

import com.company.entity.Orders;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class OrdersDaoImpl implements OrdersDao{
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
    public void insert(Orders orders) throws SQLException {
        String sql = " insert into orders (odate, ostate, fk_uid, oid) values (?, ?, ?, ?) ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, orders.getOdate());
        ps.setString(2, orders.getOstate());
        ps.setString(3, orders.getFk_uid());
        ps.setInt(4, orders.getOid());
        ps.execute();
    }

    @Override
    public void delete(int oid) throws SQLException {//删除orders表中oid的数据
        String sql = " delete from orders where oid = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1 , oid);
        ps.execute();
    }

    @Override
    public void update(int oid) throws SQLException {
        String sql = " update orders set ostate = 'cancle' where oid = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, oid);
        ps.execute();
    }

    @Override
    public String selectState(int oid) throws SQLException {//查看订单状态
        String sql = " select ostate from orders where oid = ? ";
        String result = "";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, oid);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            result = rs.getString("ostate");
        }
        return result;
    }

    @Override
    public Collection<Orders> selectOrders(String fk_uid) throws SQLException {//查看某用户的订单
        Collection<Orders> result = new ArrayList<>();
        String sql = " select oid, odate, ostate from orders where fk_uid = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, fk_uid);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            int oid = rs.getInt("oid");
            String odate = rs.getString("odate");
            String ostate = rs.getString("ostate");
            result.add(new Orders(oid, odate, ostate));
        }
        return result;
    }

    @Override
    public Orders selectAll(int oid) throws SQLException {
        Orders result = null;
        String sql = " select * from orders where oid = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, oid);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            String odate = rs.getString("odate");
            String ostate = rs.getString("ostate");
            String fk_uid = rs.getString("fk_uid");
            result = new Orders(oid, odate, ostate, fk_uid);
        }
        return result;
    }

    @Override
    public void delByUid(String fk_uid) throws SQLException {
        String sql = " delete from orders where fk_uid = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, fk_uid);
        ps.execute();
    }

    @Override
    public void buy(int oid) throws SQLException {
        String sql = " update orders set ostate = 'complete' where oid = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, oid);
        ps.execute();
    }

}
