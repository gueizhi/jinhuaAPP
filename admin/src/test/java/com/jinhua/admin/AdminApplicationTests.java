package com.jinhua.admin;


import com.jinhua.admin.service.FQuestionService;

import com.jinhua.common.bean.PageRequest;
import com.jinhua.common.entity.Fquestion;
import com.jinhua.common.entity.FquestionES;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
class AdminApplicationTests {

    @Autowired
    FQuestionService fQuestionService;

    @Test
    public void contextLoads() {
        //增加、修改
       /* Fquestion fquestion=new Fquestion();
        fquestion.setFid(new Long(3));
        fquestion.setFtitle("这是一个问题the3");
        fquestion.setFdescription("简介");
        fquestion.setType(1);
        fquestion.setFbastanid(new Long(1));
        fquestion.setFbastan("最佳答案包含测试二字");
        fquestion.setFcreatetime(new Date());
        fQuestionService.insert(fquestion);*/
        //删除
        //fQuestionService.delete(new Long(3));

        //查询
        /*PageRequest page=new PageRequest();
        page.setPageNum(0);
        page.setPageSize(10);
        page.setKeywords("测试");
        List<FquestionES> list= fQuestionService.getQuestionsES(page);
        System.out.println("找到："+list.size());*/
    }

}