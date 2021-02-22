package com.company.entity;

/**
 * 商品类
 * pid 商品编号
 * pname 品名
 * pprice 单价
 * amount 库存
 * ptype 商品类别
 */
public class Product {
    private String pid;
    private String pname;
    private String pprice;
    private String amount;
    private String ptype;

    public Product(String pid, String pname, String pprice, String amount) {
        this.pid = pid;
        this.pname = pname;
        this.pprice = pprice;
        this.amount = amount;
    }

    public Product(String pname, String pprice, String amount) {
        this.pname = pname;
        this.pprice = pprice;
        this.amount = amount;
    }

    public Product(String pid, String pname, String pprice, String amount, String ptype) {
        this.pid = pid;
        this.pname = pname;
        this.pprice = pprice;
        this.amount = amount;
        this.ptype = ptype;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }
}
