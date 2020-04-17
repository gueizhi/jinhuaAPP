package com.jinhua.common.bean;

/**
 * 分页查询请求封装类
 */
public class PageRequest {


    /**
     * 当前页码
     */
    private int pageNum=0;
    /**
     * 每页数量
     */
    private int pageSize=10;

    /**
     * 关键词
     * @return
     */
    private String keywords;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public PageRequest(int pageNum, int pageSize, String keywords) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.keywords = keywords;
    }
    public PageRequest(){}
}
