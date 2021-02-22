package com.company.entity;

/**
 * 管理员
 * mid 管理员登录编号
 * mname 管理员名字
 * mpwd 登录密码
 */
public class Manager {
    private String mid;
    private String mname;
    private String mpwd;

    public Manager(String mid, String mname, String mpwd) {
        this.mid = mid;
        this.mname = mname;
        this.mpwd = mpwd;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMpwd() {
        return mpwd;
    }

    public void setMpwd(String mpwd) {
        this.mpwd = mpwd;
    }
}
