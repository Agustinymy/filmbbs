package com.ymy.entity;

/**
 * @BelongsProject: filmbbs
 * @BelongsPackage: com.ymy.entity
 * @Author: ymy
 * @CreateTime: 2018-12-13 09:55
 * @Description: 用户实体类
 * @Version: 1.0
 */
public class User {
    private Integer uid;
    private String uname;
    private String upass;
    private Integer uflag;
    private Integer ustate;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public Integer getUflag() {
        return uflag;
    }

    public void setUflag(Integer uflag) {
        this.uflag = uflag;
    }

    public Integer getUstate() {
        return ustate;
    }

    public void setUstate(Integer ustate) {
        this.ustate = ustate;
    }
}
