package com.jinhua.admin.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员权限
 * 2020-03-31
 */
public class FSecurityALL implements Serializable{
    private Integer authorityId;
    private String authorityName;
    private Integer orderNumber=1;
    private String menuUrl;
    private String menuIcon="";
    private Date createTime;
    private String authority=null;
    private Integer checked=0;
    private Date updateTime;
    private Integer isMenu=1;
    private Integer parentId;
    public FSecurityALL() {}
    public FSecurityALL(FSecurity fSecurity)
    {
        this.authorityId=fSecurity.getFid();
        this.authorityName=fSecurity.getFname();
        if(fSecurity.getForder()!=null){
            this.orderNumber=fSecurity.getForder();
        }
        this.menuUrl=fSecurity.getFurl();
        this.parentId= fSecurity.getFparentid();
        this.authority=fSecurity.getFdescription();
    }
    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Integer getChecked() {
        return checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(Integer isMenu) {
        this.isMenu = isMenu;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }


}
