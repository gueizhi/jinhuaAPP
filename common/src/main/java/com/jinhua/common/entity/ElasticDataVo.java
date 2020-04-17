package com.jinhua.common.entity;



/**
 * @ClassName ElasticDataVo
*/
public class ElasticDataVo<T> {

    /**
     * 索引名
     */
    private String idxName;
    /**
     * 数据存储对象
     */
    private ElasticEntity elasticEntity;

    public String getIdxName() {
        return idxName;
    }

    public ElasticDataVo(){}

    public ElasticDataVo(String idxName,ElasticEntity elasticEntity){
        this.idxName=idxName;
        this.elasticEntity=elasticEntity;
    }

    public void setIdxName(String idxName) {
        this.idxName = idxName;
    }

    public ElasticEntity getElasticEntity() {
        return elasticEntity;
    }

    public void setElasticEntity(ElasticEntity elasticEntity) {
        this.elasticEntity = elasticEntity;
    }
}
