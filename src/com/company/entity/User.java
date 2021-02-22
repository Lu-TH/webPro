package com.company.entity;

/**
 * 用户类
 * uid 用户登录名
 * uname 用户姓名
 * upwd 登录密码
 * uphone 联系电话
 * ulogo 头像
 * uaddress 收货地址
 */
public class User {
    private String uid;
    private String uname;
    private String upwd;
    private String uphone;
    private String ulogo;
    private String uaddress;

    public User(String uname, String uphone) {
        this.uname = uname;
        this.uphone = uphone;
    }

    public User(String uname, String uphone, String ulogo, String uaddress) {
        this.uname = uname;
        this.uphone = uphone;
        this.ulogo = ulogo;
        this.uaddress = uaddress;
    }

    public User(String uid, String upwd, String uphone) {
        this.uid = uid;
        this.upwd = upwd;
        this.uphone = uphone;
    }

    public User() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getUlogo() {
        return ulogo;
    }

    public void setUlogo(String ulogo) {
        this.ulogo = ulogo;
    }

    public String getUaddress() {
        return uaddress;
    }

    public void setUaddress(String uaddress) {
        this.uaddress = uaddress;
    }
}
