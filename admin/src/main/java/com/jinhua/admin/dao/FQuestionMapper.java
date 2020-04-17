package com.jinhua.admin.dao;


import com.jinhua.admin.entity.Fadmin;
import com.jinhua.common.entity.Fquestion;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface FQuestionMapper {
    /**
     * 新增
     */
    long insert(Fquestion fquestion);

    /**
     * 删除
     */
    int del(long fid);

    /**
     * 修改
     */
    int update(Fquestion fquestion);


    /**
     * 根据ID查询管理员
     * @return
     */
    List<Fquestion> findByKewords(String kewords);

    /**
     * 为修改表单做回显
     */
    Fquestion findById(Long id);

    /**
     * 查询管理员集合
     */
    List<Fquestion> selectAll();


}
