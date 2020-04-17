package com.jinhua.admin.entity;

import java.io.Serializable;

/**
 *  角色权限
 *  ljx 2020-03-31
 */
public class FRoleSecurity implements Serializable {
    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public Integer getFsecurityid() {
        return fsecurityid;
    }

    public void setFsecurityid(Integer fsecurityid) {
        this.fsecurityid = fsecurityid;
    }

    public Integer getFroleid() {
        return froleid;
    }

    public void setFroleid(Integer froseid) {
        this.froleid = froseid;
    }

    //fid
    private Integer fid;
    //权限 ID
    private Integer fsecurityid;
    //角色 ID
    private Integer froleid;

}
