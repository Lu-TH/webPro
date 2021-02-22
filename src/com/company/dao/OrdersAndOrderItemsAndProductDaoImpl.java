package com.company.dao;

import com.company.entity.OrdersAndOrderItemsAndProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class OrdersAndOrderItemsAndProductDaoImpl implements OrdersAndOrderItemsAndProductDao {
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
    public Collection<OrdersAndOrderItemsAndProduct> showOrdersInfo(String uid) throws SQLException{
        Collection<OrdersAndOrderItemsAndProduct> result = new ArrayList<>();
        String sql = " select o.oid, o.odate, o.ostate, oi.quantity, p.pname, p.pprice, p.ptype from orders o left join order_items oi on o.oid = oi.fk_oid left join product p on p.pid = oi.fk_pid where o.fk_uid = ? and o.ostate is null; ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, uid);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            int oid = rs.getInt("oid");
            String odate = rs.getString("odate");
            String ostate = rs.getString("ostate");
            int quantity = rs.getInt("quantity");
            String pname = rs.getString("pname");
            String pprice = rs.getString("pprice");
            String ptype = rs.getString("ptype");
            result.add(new OrdersAndOrderItemsAndProduct(oid, odate, ostate, quantity, pname, pprice, ptype));
        }
        return result;
    }

    @Override
    public Collection<OrdersAndOrderItemsAndProduct> showArrearageOrder(String uid) throws SQLException {
        Collection<OrdersAndOrderItemsAndProduct> result = new ArrayList<>();
        String sql = " select o.oid, o.odate, o.ostate, oi.quantity, p.pname, p.pprice, p.ptype from orders o left join order_items oi on o.oid = oi.fk_oid left join product p on p.pid = oi.fk_pid where o.ostate is null and o.fk_uid = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, uid);
        ResultSet rs = ps.executeQuery();
        //System.out.println("...");
        while(rs.next()){
            int oid = rs.getInt("oid");
            //System.out.println("...");
            System.out.println(oid);
            String odate = rs.getString("odate");
            System.out.println(odate);
            String ostate = rs.getString("ostate");
            int quantity = rs.getInt("quantity");
            String pname = rs.getString("pname");
            String pprice = rs.getString("pprice");
            String ptype = rs.getString("ptype");
            result.add(new OrdersAndOrderItemsAndProduct(oid, odate, ostate, quantity, pname, pprice, ptype));
        }
        return result;
    }

}
