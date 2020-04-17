package com.jinhua.admin.controller;

import com.github.pagehelper.PageInfo;
import com.jinhua.admin.entity.FSysargsVo;
import com.jinhua.admin.entity.Fsysargs;
import com.jinhua.admin.entity.ReturnData;
import com.jinhua.admin.service.FsysargsService;
import com.jinhua.common.bean.PageRequest;
import com.jinhua.common.tool.RedisTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 管理系统 controller层
 * Created by zhaorui on 2020/4/7
 */
@Controller
@RequestMapping("fsysargs")
public class FsysargsController {

     private static Logger logger= LoggerFactory.getLogger(Test.class);
     @Autowired
     private FsysargsService fsysargsService;
     @Autowired
     private RedisTool redisTool;

    /**
     * 查询所有(可以用)
     */
    @RequestMapping("/selectAllFSysargs")
    @ResponseBody
    public ReturnData List(FSysargsVo fSysargsVo){
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageNum(fSysargsVo.getPage());
        pageRequest.setPageSize(fSysargsVo.getSize());

        if (fSysargsVo.getFkey()==""){
            fSysargsVo.setFkey(null);
        }

        PageInfo<Fsysargs> list = fsysargsService.findFSysargsByfkey(pageRequest, fSysargsVo.getFkey());
        ReturnData returnData = new ReturnData();
        returnData.setCount(list.getTotal());
        returnData.setData(list.getList());
        return returnData;
    }

    /**
     * 系统参数添加
     * @param fSysargsVo
     * @return
     */
    @RequestMapping("/addFSysargs")
    @ResponseBody
    public ReturnData addFSysargs(FSysargsVo fSysargsVo){
        ReturnData returnData = new ReturnData();
        Fsysargs fsysargs = fsysargsService.findByKey(fSysargsVo.getFkey());
        if (fsysargs==null){
            fsysargsService.saveFsysargs(fSysargsVo);
            returnData.setCode(200);
            returnData.setMsg("添加成功");
            return returnData;
        }else {
            returnData.setMsg("参数名已存在");
            return returnData;
        }
    }

    /**
     * 更新系统参数
     * @param fsysargs
     * @return
     */
    @RequestMapping("/editFSysargs")
    @ResponseBody
    public  ReturnData editFSysargs(Fsysargs fsysargs){
        ReturnData returnData = new ReturnData();

        Fsysargs fsysargs2 = fsysargsService.findFsysargsById(fsysargs.getFid());
        Fsysargs fsysargs1 = fsysargsService.findByKey(fsysargs.getFkey());
        if (fsysargs2.getFkey().equals(fsysargs.getFkey())){
            fsysargsService.updateFsysargs(fsysargs);
            returnData.setCode(200);
            returnData.setMsg("修改成功");
            return returnData;
        }else {
            if (fsysargs1==null){
                fsysargsService.updateFsysargs(fsysargs);
                returnData.setCode(200);
                returnData.setMsg("修改成功");
                return returnData;
            }else {
                returnData.setMsg("用户已存在");
                return returnData;
            }
        }
    }

    /**
     * 系统参数删除操作
     * @param fsysargs
     * @return
     */
    @ResponseBody
    @RequestMapping("/deleteFSysargs")
    public ReturnData deleteFSysargs(Fsysargs fsysargs){
        ReturnData returnData = new ReturnData();
        fsysargsService.deleteFsysargsById(fsysargs);
        returnData.setCode(200);
        returnData.setMsg("删除成功");

        return returnData;
    }


    /**
     * 跳转添加页面
     */
    @RequestMapping("/goAdd")
    public ModelAndView goAdd(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("fsysargs/addfsysargs");
        return modelAndView;
    }

    /**
     * 跳转到更新页面
     */
    @RequestMapping("/goEdit")
    public ModelAndView goEdit(@RequestParam(value="fid") Integer fid){
        ModelAndView modelAndView = new ModelAndView();
        Fsysargs fsysargs = fsysargsService.findFsysargsById(fid);
        modelAndView.addObject("fsysargs",fsysargs);
        modelAndView.setViewName("fsysargs/edit");
        return modelAndView;
    }

    @RequestMapping("/init")
    @ResponseBody
    public ReturnData init(){
        ReturnData returnData = new ReturnData();
        fsysargsService.init();
        returnData.setMsg("初始化Redis成功");
        return returnData;
    }

}
