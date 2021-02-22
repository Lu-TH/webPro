package com.company.entity;

/**
 * 订单详情
 * fk_oid 所属订单号
 * fk_pid 商品编号
 * quantity 购买数量
 */
public class OrderItems {
    private int fk_oid;
    private String fk_pid;
    private int quantity;

    public OrderItems(int fk_oid, String fk_pid, int quantity) {
        this.fk_oid = fk_oid;
        this.fk_pid = fk_pid;
        this.quantity = quantity;
    }

    public int getFk_oid() {
        return fk_oid;
    }

    public void setFk_oid(int fk_oid) {
        this.fk_oid = fk_oid;
    }

    public String getFk_pid() {
        return fk_pid;
    }

    public void setFk_pid(String fk_pid) {
        this.fk_pid = fk_pid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
