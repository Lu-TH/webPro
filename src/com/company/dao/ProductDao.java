package com.company.dao;

import com.company.entity.Product;

import java.sql.SQLException;
import java.util.Collection;

/**
 * 增加商品
 * 删除商品
 * 更新商品信息
 * 用户查找特定商品--根据类型查找(ptype)
 */
public interface ProductDao {
    public void insert(Product product) throws SQLException;//增加商品 传入product 对象
    public void delete(String pid) throws SQLException;//删除商品 根据商品pid 删除
    public void update(Product product) throws SQLException;//更新信息 把新的信息封装到product对象中
    public Collection<Product> select(String ptype) throws SQLException;
    public Collection<Product> selectAllAsc(String ascOrDesc) throws SQLException;//查找所有商品并按价格排序
    public Collection<Product> selectAllDesc() throws SQLException;//倒序
}
