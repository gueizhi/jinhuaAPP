package com.jinhua.common.entity;


import java.util.Date;

/**
 * ES问题实体类
 */

public class FquestionES {
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
    //赞
    private Integer fpraise;
    //最后更新时间
    private Date fupdatetime;
    //创建时间
    private Date fcreatetime;

    public FquestionES(Long fid,String ftitle,String fdescription,
                       Integer fpraise,Date fupdatetime,Date fcreatetime,Long fbastanid,String fbastan)
    {
        this.fid=fid;
        this.ftitle=ftitle;
        this.fdescription=fdescription;
        this.fpraise=fpraise;
        this.fupdatetime=fupdatetime;
        this.fcreatetime=fcreatetime;
        this.fbastanid=fbastanid;
        this.fbastan=fbastan;

    }
    public FquestionES(Fquestion fquestion)
    {
        this.fid=fquestion.getFid();
        this.ftitle=fquestion.getFtitle();
        this.fdescription=fquestion.getFdescription();
        this.fpraise=fquestion.getFpraise();
        this.fupdatetime=fquestion.getFupdatetime();
        this.fcreatetime=fquestion.getFcreatetime();
        this.fbastanid=fquestion.getFbastanid();
        this.fbastan=fquestion.getFbastan();

    }

    public FquestionES(){}


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

    public Integer getFpraise() {
        return fpraise;
    }

    public void setFpraise(Integer fpraise) {
        this.fpraise = fpraise;
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
