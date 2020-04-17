package com.jinhua.admin.entity;

import java.util.Date;

public class Fsysargs {
    private Integer fid;
    private String fkey;
    private Integer ftype;
    private String fvalue;
    private String fdescripttion;
    private String fversion;
    private String furl;
    private Date fcreatetime;

    public Fsysargs(Integer fid, String fkey, Integer ftype, String fvalue, String fdescripttion, String fversion, String furl, Date fcreatetime) {
        this.fid = fid;
        this.fkey = fkey;
        this.ftype = ftype;
        this.fvalue = fvalue;
        this.fdescripttion = fdescripttion;
        this.fversion = fversion;
        this.furl = furl;
        this.fcreatetime = fcreatetime;
    }

    public Fsysargs() {
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getFkey() {
        return fkey;
    }

    public void setFkey(String fkey) {
        this.fkey = fkey;
    }

    public Integer getFtype() {
        return ftype;
    }

    public void setFtype(Integer ftype) {
        this.ftype = ftype;
    }

    public String getFvalue() {
        return fvalue;
    }

    public void setFvalue(String fvalue) {
        this.fvalue = fvalue;
    }

    public String getFdescripttion() {
        return fdescripttion;
    }

    public void setFdescripttion(String fdescripttion) {
        this.fdescripttion = fdescripttion;
    }

    public String getFversion() {
        return fversion;
    }

    public void setFversion(String fversion) {
        this.fversion = fversion;
    }

    public String getFurl() {
        return furl;
    }

    public void setFurl(String furl) {
        this.furl = furl;
    }

    public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }
}
