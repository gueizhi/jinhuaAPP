package com.jinhua.common.entity;


import java.util.Date;

public class Fquestion {
    //id
    private Long fid;
    //问题标题
    private String ftitle;
    //问题描述
    private String fdescription;
    //最佳答案ID
    private Long fbastanid;
    //最佳答案
    private String fbastan;
    //类型
    private Integer ftype;
    //赞
    private Integer fpraise;
    //浏览量
    private Integer fpv;
    //管理员id
    private Integer fadminid;
    //用户ID
    private Integer fuserid;
    //最后更新时间
    private Date fupdatetime;
    //创建时间
    private Date fcreatetime;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public String getFtitle() {
        return ftitle;
    }

    public void setFtitle(String ftitle) {
        this.ftitle = ftitle;
    }

    public String getFdescription() {
        return fdescription;
    }

    public void setFdescription(String fdescription) {
        this.fdescription = fdescription;
    }

    public Integer getFtype() {
        return ftype;
    }

    public void setFtype(Integer ftype) {
        this.ftype = ftype;
    }

    public Integer getFpraise() {
        return fpraise;
    }

    public void setFpraise(Integer fpraise) {
        this.fpraise = fpraise;
    }

    public Integer getFpv() {
        return fpv;
    }

    public void setFpv(Integer fpv) {
        this.fpv = fpv;
    }

    public Integer getFadminid() {
        return fadminid;
    }

    public void setFadminid(Integer fadminid) {
        this.fadminid = fadminid;
    }

    public Integer getFuserid() {
        return fuserid;
    }

    public void setFuserid(Integer fuserid) {
        this.fuserid = fuserid;
    }

    public Date getFupdatetime() {
        return fupdatetime;
    }

    public void setFupdatetime(Date fupdatetime) {
        this.fupdatetime = fupdatetime;
    }

    public Date getFcreatetime() {
        return fcreatetime;
    }

    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }

    public Long getFbastanid() {
        return fbastanid;
    }

    public void setFbastanid(Long fbastanid) {
        this.fbastanid = fbastanid;
    }

    public String getFbastan() {
        return fbastan;
    }

    public void setFbastan(String fbastan) {
        this.fbastan = fbastan;
    }
}
