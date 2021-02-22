package com.company.dao;

import com.company.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class UserDaoImpl implements UserDao{
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
    public void insert(User user) throws SQLException {//注册
        String sql = " insert into user (uid, upwd, uphone) values (?, ?, ?) ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, user.getUid());
        ps.setString(2, user.getUpwd());
        ps.setString(3, user.getUphone());
        ps.execute();
    }

    @Override
    public String selectPwd(String uid) throws SQLException {//登录 查找密码
        String truePwd = "";
        String sql = " select upwd from user where uid = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, uid);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            truePwd = rs.getString("upwd");
        }
        return truePwd;
    }

    @Override
    public User selectInfo(String uid) throws SQLException {//展示个人信息
        User user = null;
        String sql = " select uname, uphone, uaddress, ulogo from user where uid = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, uid);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            String uname = rs.getString("uname");
            String uphone = rs.getString("uphone");
            String uaddress = rs.getString("uaddress");
            String ulogo = rs.getString("ulogo");
            user = new User(uname, uphone, ulogo, uaddress);
        }
        return user;
    }

    @Override
    public void update(User user) throws SQLException {//修改信息 包括联系方式和头像
        String sql = " update user set uphone = ?, ulogo = ?, uaddress = ? where uid = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, user.getUphone());
        ps.setString(2, user.getUlogo());
        ps.setString(3, user.getUaddress());
        ps.setString(4, user.getUid());
        ps.execute();
    }

    @Override
    public void delete(String uid) throws SQLException {//删除用户
        String sql = " delete from user where uid = ? ";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, uid);
        ps.execute();
    }

    @Override
    public Collection<User> selectAll() throws SQLException {
        Collection<User> userCollection = new ArrayList<>();
        String sql = " select uname, uphone from user ";
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()){
            String uname = rs.getString("uname");
            String uphone = rs.getString("uphone");
            User user = new User();
            user.setUname(uname);
            user.setUphone(uphone);
            userCollection.add(user);
        }
        return userCollection;
    }
}
