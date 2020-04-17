package com.jinhua.common.entity;


import java.util.Map;

/**
 * @ClassName ElasticEntity
 * @Description  数据存储对象
*/

public class ElasticEntity<T> {

    /**
     * 主键标识，用户ES持久化
     */
    private String id;

    /**
     * JSON对象，实际存储数据
     */
    private FquestionES fquestionES;
    public ElasticEntity(){}

    public ElasticEntity(String id,FquestionES fquestionES){
        this.id=id;
        this.fquestionES=fquestionES;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public FquestionES getFquestionES() {
        return fquestionES;
    }

    public void setFquestionES(FquestionES fquestionES) {
        this.fquestionES = fquestionES;
    }
}
