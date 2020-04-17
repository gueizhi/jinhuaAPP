package com.jinhua.admin.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FLogAdmin {

    private static final long serialVersionUID = 1L;
    private int fid;
    private Integer fadminid;
    private String fip;
    private Integer fuid;
    private Integer ftype;
    private Integer fadmintype;
    private String fdata;
    private Date fcreatetime;

    /**
     * 请求参数
     */
    private Map<String, Object> params;

    /**
     * 关联表fadmin中管理员名称字段
     */
    private String fusername;

    /**
     * 关联表fuser中用户名称字段
     */
    private String fname;

    /**
     * 为前端展示ftype中文使用
     */
    private String type;

    /**
     * 为前端展示fadmintype中文使用
     */
    private String admintype;

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public Integer getFadminid() {
        return fadminid;
    }

    public void setFadminid(Integer fadminid) {
        this.fadminid = fadminid;
    }

    public String getFip() {
        return fip;
    }

    public void setFip(String fip) {
        this.fip = fip;
    }

    public Integer getFuid() {
        return fuid;
    }

    public void setFuid(Integer fuid) {
        this.fuid = fuid;
    }

    public Integer getFtype() {
        return ftype;
    }

    public void setFtype(Integer ftype) {
        this.ftype = ftype;
    }

    public Integer getFadmintype() {
        return fadmintype;
    }

    public void setFadmintype(Integer fadmintype) {
        this.fadmintype = fadmintype;
    }

    public String getFdata() {
        return fdata;
    }

    public void setFdata(String fdata) {
        this.fdata = fdata;
    }

    public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }


    public Map<String, Object> getParams() {
        if (params == null) {
            params = new HashMap<>();
        }
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getFusername() {
        return fusername;
    }

    public void setFusername(String fusername) {
        this.fusername = fusername;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdmintype() {
        return admintype;
    }

    public void setAdmintype(String admintype) {
        this.admintype = admintype;
    }
}
