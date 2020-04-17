package com.jinhua.admin.entity;

import java.io.Serializable;

/**
 * 管理员权限
 * 2020-03-31
 */
public class FSecurity implements Serializable {
    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFdescription() {
        return fdescription;
    }

    public void setFdescription(String fdescription) {
        this.fdescription = fdescription;
    }

    public String getFurl() {
        return furl;
    }

    public void setFurl(String furl) {
        this.furl = furl;
    }

    public Integer getFparentid() {
        return fparentid;
    }

    public void setFparentid(Integer fparentid) {
        this.fparentid = fparentid;
    }

    public Integer getForder() {
        return forder;
    }

    public void setForder(Integer forder) {
        this.forder = forder;
    }

    //fid
    private Integer fid;
    //权限名称
    private String fname;
    //权限描述
    private String fdescription;
    //权限路径
    private String furl;
    //权限上级ID
    private Integer fparentid;
    //排序
    private Integer forder;

}
