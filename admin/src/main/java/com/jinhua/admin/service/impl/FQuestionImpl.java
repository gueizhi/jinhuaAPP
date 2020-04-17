package com.jinhua.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jinhua.admin.dao.FQuestionMapper;
import com.jinhua.common.entity.*;
import com.jinhua.admin.service.ElasticService;
import com.jinhua.admin.service.FQuestionService;
import com.jinhua.common.Enum.EsEnum;
import com.jinhua.common.bean.PageRequest;
import com.jinhua.common.util.ElasticUtil;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class FQuestionImpl implements FQuestionService {
    @Autowired
    ElasticService elasticService;

    @Autowired
    FQuestionMapper fQuestionMapper;
    /**
     * 插入问题
     * @param fquestion
     * @return
     */
    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insert(Fquestion fquestion) throws Exception  {
        Long r=fQuestionMapper.insert(fquestion);
        if(r<=0){
                throw new Exception();
        }
        ElasticEntity en=new ElasticEntity();
        en.setId(fquestion.getFid().toString());
        en.setFquestionES(new FquestionES(fquestion));
        /*ElasticDataVo elasticDataVo=new ElasticDataVo();
        elasticDataVo.setIdxName(EsEnum.ES_INDEX);
        elasticDataVo.setElasticEntity(en);*/
        elasticService.insertOrUpdateOne(EsEnum.ES_INDEX, en);
        return 1;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int delete(Long fid)  throws Exception  {
        int r=fQuestionMapper.del(fid);
        if(r<=0) {
            throw new Exception();
        }
        ElasticEntity entity=new ElasticEntity();
        entity.setId(fid.toString());
        elasticService.deleteOne(EsEnum.ES_INDEX,entity);
        return r;
    }

    @Override
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int update(Fquestion fquestion)  throws Exception {
        int r=fQuestionMapper.update(fquestion);
        if(r<=0) {
            throw new Exception();
        }
        ElasticEntity en=new ElasticEntity();
        en.setId(fquestion.getFid().toString());
        en.setFquestionES(new FquestionES(fquestion));
        elasticService.insertOrUpdateOne(EsEnum.ES_INDEX, en);
        return r;
    }

    @Override
    public Fquestion getFquestionById(Long fid) {
        return fQuestionMapper.findById(fid);
    }

    @Override
    public PageInfo<Fquestion> getFquestions(PageRequest pageRequest) {
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<Fquestion> list=fQuestionMapper.selectAll();
        return new PageInfo<>(list);
    }
    @Override
    public List<FquestionES> getQuestionsES(PageRequest pageRequest)
    {
        // 创建BoolQueryBuilder对象
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        // 设置boolQueryBuilder条件
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = QueryBuilders
                .matchPhraseQuery("ftitle", pageRequest.getKeywords());
        MatchPhraseQueryBuilder matchPhraseQueryBuilder2 = QueryBuilders
                .matchPhraseQuery("fbastan", pageRequest.getKeywords());
        /*RangeQueryBuilder rangeQueryBuilder = QueryBuilders
                .rangeQuery("postdate")
                .from("2016-01-01 00:00:00");*/
        // 子boolQueryBuilder条件条件，用来表示查询条件or的关系
        BoolQueryBuilder childBoolQueryBuilder = new BoolQueryBuilder()
                .should(matchPhraseQueryBuilder)
                .should(matchPhraseQueryBuilder2);
        // 添加查询条件到boolQueryBuilder中
        boolQueryBuilder.must(childBoolQueryBuilder);
                //.must(rangeQueryBuilder);
        // 创建并设置SearchSourceBuilder对象
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 查询条件--->生成DSL查询语句
        searchSourceBuilder.query(boolQueryBuilder);
        // 第几页
        searchSourceBuilder.from(pageRequest.getPageNum());
        // 每页多少条数据
        searchSourceBuilder.size(pageRequest.getPageSize());
        // 设置排序规则
        searchSourceBuilder.sort("fcreatetime", SortOrder.DESC);
        // 设置超时时间为2s
        searchSourceBuilder.timeout(new TimeValue(2000));
        Class<?> clazz = ElasticUtil.getClazz(FquestionES.class.getName());
        List<?> data = elasticService.search(EsEnum.ES_INDEX,searchSourceBuilder,clazz);
        return (List<FquestionES>) data;
    }
    @Override
    public List<FquestionES> getEsQuestions(PageRequest pageRequest) {
        try {
            Map<String,Object> where=new HashMap<>();
            where.put("ftitle",pageRequest.getKeywords());
            //where.put("fbastan",pageRequest.getKeywords());
            Class<?> clazz = ElasticUtil.getClazz(FquestionES.class.getName());
            Set<String> keys = where.keySet();
            MatchQueryBuilder queryBuilders=null;
            for(String ke:keys){
                queryBuilders = QueryBuilders.matchQuery(ke, where.get(ke));
            }
            if(null!=queryBuilders){
                SearchSourceBuilder searchSourceBuilder = ElasticUtil.initSearchSourceBuilder(queryBuilders);
                List<?> data = elasticService.search(EsEnum.ES_INDEX,searchSourceBuilder,clazz);
                return (List<FquestionES>) data;
            }
        } catch (Exception e) {
            System.out.println("查询数据异常");
        }
        return null;
    }
}
