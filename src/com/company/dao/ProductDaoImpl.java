package com.company.dao;

import com.company.entity.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;


public class ProductDaoImpl implements ProductDao{
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
    public void insert(Product product) throws SQLException {//增加商品
        String sql = " insert into product values(?, ?, ?, ?, ?) ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, product.getPid());
        ps.setString(2, product.getPname());
        ps.setString(3, product.getPprice());
        ps.setString(4, product.getAmount());
        ps.setString(5, product.getPtype());
        ps.execute();
    }

    @Override
    public void delete(String pid) throws SQLException {//删除商品
        String sql = "delete from product where pid = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, pid);
        ps.execute();
    }

    @Override
    public void update(Product product) throws SQLException {//更新信息 把新的信息封装到product对象中
        String sql = " update product set pname = ?, pprice = ? ,amount = ?, ptype = ? where pid = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, product.getPname());
        ps.setString(2, product.getPprice());
        ps.setString(3, product.getAmount());
        ps.setString(4, product.getPtype());
        ps.setString(5, product.getPid());
        ps.execute();
    }

    @Override
    public Collection<Product> select(String ptype) throws SQLException {//按类型查找商品
        Collection<Product> result = new ArrayList<>();
        String sql = " select pname, pprice, amount from product where ptype = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, ptype);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            String pname = rs.getString("pname");
            String pprice = rs.getString("pprice");
            String amount = rs.getString("amount");
            result.add(new Product(pname, pprice, amount));
        }
        return result;
    }

    @Override
    public Collection<Product> selectAllAsc(String ascOrDesc) throws SQLException {//查找所有商品并按价格排序 默认从小到大排序
        Collection<Product> result = new ArrayList<>();
        String sql = " select * from product order by pprice asc ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            String pname = rs.getString("pname");
            String pprice = rs.getString("pprice");
            String amount = rs.getString("amount");
            String pid = rs.getString("pid");
            result.add(new Product(pid, pname, pprice, amount));
        }
        return result;
    }

    @Override
    public Collection<Product> selectAllDesc() throws SQLException {
        Collection<Product> result = new ArrayList<>();
        String sql = " select pname, pprice, amount from product order by pprice desc ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            String pname = rs.getString("pname");
            String pprice = rs.getString("pprice");
            String amount = rs.getString("amount");
            result.add(new Product(pname, pprice, amount));
        }
        return result;
    }
}
