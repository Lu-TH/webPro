package com.company.entity;

/**
 * 订单类
 * oid 订单编号
 * odate 订单生成日期
 * ostate 订单状态
 * fk_uid 订单所属用户
 */
public class Orders {
    private int oid;
    private String odate;
    private String ostate;
    private String fk_uid;

    public Orders(int oid, String odate, String ostate, String fk_uid) {
        this.oid = oid;
        this.odate = odate;
        this.ostate = ostate;
        this.fk_uid = fk_uid;
    }

    public Orders(int oid, String odate, String ostate) {
        this.oid = oid;
        this.odate = odate;
        this.ostate = ostate;
    }

    public Orders(String odate, String fk_uid, int oid) {
        this.odate = odate;
        this.fk_uid = fk_uid;
        this.oid = oid;
    }

    public Orders(String odate, String ostate, String fk_uid) {
        this.odate = odate;
        this.ostate = ostate;
        this.fk_uid = fk_uid;
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

    public String getFk_uid() {
        return fk_uid;
    }

    public void setFk_uid(String fk_uid) {
        this.fk_uid = fk_uid;
    }
}
