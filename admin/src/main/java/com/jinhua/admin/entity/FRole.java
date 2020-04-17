package com.jinhua.admin.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *  角色
 *  ljx 2020-03-31
 */
public class FRole implements Serializable {
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

    public Integer getFdeptid() {
        return fdeptid;
    }

    public void setFdeptid(Integer fdeptid) {
        this.fdeptid = fdeptid;
    }

    public List<FRoleSecurity> getFroleSecurities() {
        return froleSecurities;
    }

    public void setFroleSecurities(List<FRoleSecurity> froleSecurities) {
        this.froleSecurities = froleSecurities;
    }
    //fid
    private Integer fid;
    //角色名称
    private String fname;
    //角色描述
    private String fdescription;
    //组织机构权限（预留）
    private Integer fdeptid;
    //角色权限
    private List<FRoleSecurity> froleSecurities = new ArrayList<FRoleSecurity>();
}
