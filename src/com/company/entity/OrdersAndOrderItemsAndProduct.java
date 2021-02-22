package com.company.entity;

import java.util.Collection;

/**
 * 用户查找个人订单详细信息 实体类
 *
 * fk_oid 订单号
 * odate 订单日期
 * ostate 订单状态
 * quantity 已购的一件商品的数量
 * pname 已购商品名
 * pprice 已购商品的单价
 * ptype 已购商品类型
 */

public class OrdersAndOrderItemsAndProduct {
    private int oid;
    private String odate;
    private String ostate;
    private int quantity;
    private String pname;
    private String pprice;
    private String ptype;

    public OrdersAndOrderItemsAndProduct() {
    }

    public OrdersAndOrderItemsAndProduct(int oid, String odate, String ostate, int quantity, String pname, String pprice, String ptype) {
        this.oid = oid;
        this.odate = odate;
        this.ostate = ostate;
        this.quantity = quantity;
        this.pname = pname;
        this.pprice = pprice;
        this.ptype = ptype;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getOdate() {
        return odate;
    }

    public void setOdate(String odate) {
        this.odate = odate;
    }

    public String getOstate() {
        return ostate;
    }

    public void setOstate(String ostate) {
        this.ostate = ostate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPprice() {
        return pprice;
    }

    public void setPprice(String pprice) {
        this.pprice = pprice;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }

    @Override
    public String toString() {
        return "OrdersAndOrderItemsAndProduct{" +
                "oid='" + oid + '\'' +
                ", odate='" + odate + '\'' +
                ", ostate='" + ostate + '\'' +
                ", quantity=" + quantity +
                ", pname='" + pname + '\'' +
                ", pprice='" + pprice + '\'' +
                ", ptype='" + ptype + '\'' +
                '}';
    }
}
