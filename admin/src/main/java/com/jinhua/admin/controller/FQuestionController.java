package com.jinhua.admin.controller;

import com.github.pagehelper.PageInfo;
import com.jinhua.admin.entity.FQuestionVo;
import com.jinhua.admin.entity.FSecurity;
import com.jinhua.admin.entity.ReturnData;
import com.jinhua.admin.service.FQuestionService;
import com.jinhua.common.bean.PageRequest;
import com.jinhua.common.entity.Fquestion;
import com.jinhua.common.entity.FquestionES;
import com.jinhua.common.util.ReturnResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FQuestionController {
    @Autowired
    FQuestionService fQuestionService;

    @RequestMapping("/question/getAllQuestion")
    @ResponseBody
    public ReturnData getAllQuestion(FQuestionVo fQuestionVo)
    {
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageSize(fQuestionVo.getSize());
        pageRequest.setPageNum(fQuestionVo.getPage());
        PageInfo<Fquestion> pageInfo=fQuestionService.getFquestions(pageRequest);
        long total = pageInfo.getTotal();
        ReturnData returnDate= new ReturnData();
        returnDate.setData(pageInfo.getList());
        returnDate.setCount(total);
        return returnDate;
    }

    @RequestMapping("/question/findQuestion")
    @ResponseBody
    public ReturnData findQuestion(FQuestionVo fQuestionVo,String keywords)
    {
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageSize(fQuestionVo.getSize());
        pageRequest.setPageNum(fQuestionVo.getPage()-1);
        pageRequest.setKeywords(keywords);

        List<FquestionES> list= fQuestionService.getQuestionsES(pageRequest);
        PageInfo<Fquestion> pageInfo=new PageInfo<>();
        long total = pageInfo.getTotal();
        ReturnData returnDate= new ReturnData();
        returnDate.setData(list);
        returnDate.setCount(total);
        return returnDate;
    }

    /**
     * 新增问答
     */
    @RequestMapping("question/addQuestion")
    @ResponseBody
    public ReturnResult addQuestion(Fquestion fquestion){

        int result=0;
        try {
            result=fQuestionService.insert(fquestion);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnResult.FAILUER("添加失败");
        }
        if(result==1) {
            return ReturnResult.SUCCESS("添加成功");
        } else {
            return ReturnResult.FAILUER("添加失败");
        }
    }

    /**
     * 获得权限
     */
    @RequestMapping("quesation/getQuesation")
    public ModelAndView getSecurity(
            @RequestParam(value="fid") Long fid
    ){
        ModelAndView modelAndView = new ModelAndView();
        Fquestion fquestion= fQuestionService.getFquestionById(fid);
        if(fquestion!=null) {
            modelAndView.addObject("question", fquestion);
            modelAndView.setViewName("question/updateQuestion");
        }else
            modelAndView.setViewName("***");
        return modelAndView;
    }

    /**
     * 修改问答
     */
    @RequestMapping("question/updateQuestion")
    @ResponseBody
    public ReturnResult updateQuestion(Fquestion fquestion) throws Exception {
        Fquestion fquestion1=fQuestionService.getFquestionById(fquestion.getFid());
        int result=0;
        if(fquestion1==null) {
            return ReturnResult.FAILUER("修改失败");
        } else
        {
            result=fQuestionService.update(fquestion);
            if(result==1) {
                return ReturnResult.SUCCESS("修改成功");
            } else {
                return ReturnResult.FAILUER("修改失败");
            }
        }

    }
}
