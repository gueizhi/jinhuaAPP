package com.jinhua.common.entity;

import java.util.Map;

public class QueryVo {
    /**
     * 索引名
     */
    private String idxName;
    /**
     * 需要反射的实体类型，用于对查询结果的封装
     */
    private String className;
    /**
     * 具体条件
     */
    private Map<String, Map<String,Object>> query;

    public QueryVo(){}

    public QueryVo(String idxName,String className,Map<String, Map<String,Object>> query)
    {
        this.idxName=idxName;
        this.className=className;
        this.query=query;
    }

    public String getIdxName() {
        return idxName;
    }

    public void setIdxName(String idxName) {
        this.idxName = idxName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Map<String, Map<String, Object>> getQuery() {
        return query;
    }

    public void setQuery(Map<String, Map<String, Object>> query) {
        this.query = query;
    }
}
