package com.jinhua.admin.service;

import com.github.pagehelper.PageInfo;
import com.jinhua.common.bean.PageRequest;
import com.jinhua.common.entity.Fquestion;
import com.jinhua.common.entity.FquestionES;

import java.util.List;

public interface FQuestionService {
    /**
     * 增加问题
     * @param fquestion
     * @return
     */
    int insert(Fquestion fquestion)  throws Exception;

    /**
     * 删除问题
     * @return
     */
    int delete(Long fid)  throws Exception;

    /**
     * 修改问题
     * @return
     */
    int update(Fquestion fquestion)  throws Exception ;

    /**
     * 获得问题
     * @return
     */
    Fquestion getFquestionById(Long fid);

    /**
     * 获得所有问题
     * @return
     */
    PageInfo<Fquestion> getFquestions(PageRequest pageRequest);

    /**
     * 获得问题
     * @return
     */
    List<FquestionES> getEsQuestions(PageRequest pageRequest);
    /**
     * 获得ES问题
     * @return
     */
    List<FquestionES> getQuestionsES(PageRequest pageRequest);


}
