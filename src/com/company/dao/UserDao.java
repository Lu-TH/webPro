package com.company.dao;

import com.company.entity.User;

import java.sql.SQLException;
import java.util.Collection;

/**
 * 注册
 * 登录
 * 修改 联系方式  头像
 * 查看个人信息
 *
 * 管理员查看用户
 * 删除用户
 * 修改用户
 */
public interface UserDao {
    public void insert(User user) throws SQLException;//注册
    public String selectPwd(String uid) throws SQLException;//登录
    public User selectInfo(String uid) throws SQLException;//展示个人信息
    public void update(User user) throws SQLException;//修改信息
    public void delete(String uid) throws SQLException;//删除用户
    public Collection<User> selectAll() throws SQLException;//查看所有用户
}
