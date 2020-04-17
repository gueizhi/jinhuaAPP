package com.jinhua.admin.controller;

import com.alibaba.fastjson.JSON;
import com.jinhua.admin.service.FQuestionService;
import com.jinhua.common.bean.PageRequest;
import com.jinhua.common.entity.FquestionES;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Test {
    @Autowired
    FQuestionService fQuestionService;

    @RequestMapping("/test/testSearch")
    @ResponseBody
    public String testSearch(
            @RequestParam(value = "keyword") String keyword
    )
    {
        PageRequest pageRequest=new PageRequest();
        pageRequest.setKeywords(keyword);

        List<FquestionES> list= fQuestionService.getQuestionsES(pageRequest);
        return JSON.toJSONString(list);
    }
}
