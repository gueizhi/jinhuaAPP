package com.jinhua.admin.entity;

import java.io.Serializable;
import java.util.Date;

public class Fadmin implements Serializable {
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

    public String getFpassword() {
        return fpassword;
    }

    public void setFpassword(String fpassword) {
        this.fpassword = fpassword;
    }

    public String getFusername() {
        return fusername;
    }

    public void setFusername(String fusername) {
        this.fusername = fusername;
    }

    public Integer getFstate() {
        return fstate;
    }

    public void setFstate(Integer fstate) {
        this.fstate = fstate;
    }

    public Integer getFtype() {
        return ftype;
    }

    public void setFtype(Integer ftype) {
        this.ftype = ftype;
    }

    public Integer getFroleId() {
        return froleId;
    }

    public void setFroleId(Integer froleId) {
        this.froleId = froleId;
    }

    public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }

    private Integer fid;
    private String fname;
    private String fpassword;
    private String fusername;
    private Integer fstate;
    private Integer ftype;
    private Integer froleId;
    private Date fcreatetime;

    public String getFstate_string() {
        return fstate_string;
    }

    public void setFstate_string(String fstate_string) {
        this.fstate_string = fstate_string;
    }

    public String getFtype_string() {
        return ftype_string;
    }

    public void setFtype_string(String ftype_string) {
        this.ftype_string = ftype_string;
    }

    public String getFroleid_string() {
        return froleid_string;
    }

    public void setFroleid_string(String froleid_string) {
        this.froleid_string = froleid_string;
    }

    private String fstate_string;
    private String ftype_string;
    private String froleid_string;

    public Fadmin() {
    }


}
