package com.jinhua.admin.controller;

import com.alibaba.fastjson.JSONObject;
import com.jinhua.admin.entity.FSecurity;
import com.jinhua.admin.entity.FSecurityALL;
import com.jinhua.admin.entity.ReturnData;
import com.jinhua.admin.service.FSecurityService;
import com.jinhua.common.tool.RedisTool;
import com.jinhua.common.util.ReturnResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限管理管理
 */
@Controller
public class SecurityController {
    //输出
    private static Logger logger= LoggerFactory.getLogger(Test.class);

    @Autowired
    private FSecurityService securityService;
    @Autowired
    private RedisTool redisTool;


    /**
     * 权限列表
     */
    @RequestMapping("security/securityList")
    @ResponseBody
    public String securityList(){
        //ModelAndView modelAndView = new ModelAndView();
        List<FSecurity> list= securityService.selectAll();
        List<FSecurityALL> newList=new ArrayList<FSecurityALL>();
        for(FSecurity ss : list)
        {
            FSecurityALL ns=new FSecurityALL(ss);
            newList.add(ns);
        }
        ReturnData data=new ReturnData();
        data.setCount(Long.valueOf(newList.size()));
        data.setData(newList);
        return JSONObject.toJSON(data).toString();
    }

    /**
     * 获得权限
     */
    @RequestMapping("security/getSecurity")
    public ModelAndView getSecurity(
            @RequestParam(value="fid") Integer fid,
            @RequestParam(value="type",defaultValue = "update",required = false) String type
    ){
        ModelAndView modelAndView = new ModelAndView();
        FSecurity security= securityService.selectByPrimaryKey(fid);
        modelAndView.addObject("security",security);
        if(type.equals("update"))
            modelAndView.setViewName("security/updateSecurity");
        else if(type.equals("add"))
            modelAndView.setViewName("security/addSecurity");
        return modelAndView;
    }

    /**
     * 更新权限
     */
    @RequestMapping("security/updateSecurity")
    @ResponseBody
    public ReturnResult updateSecurity(
            @RequestParam(value="fid") Integer fid,
            @RequestParam(value="furl", required = false) String furl,
            @RequestParam(value="fdescription", required = false) String fdescription,
            @RequestParam(value="fname", required = false) String fname,
            @RequestParam(value="forder", required = false) Integer forder
    ){
        FSecurity fSecurity=securityService.selectByPrimaryKey(fid);
        if(fSecurity!=null)
        {
            fSecurity.setFname(fname);
            fSecurity.setForder(forder);
            fSecurity.setFdescription(fdescription);
            fSecurity.setFurl(furl);
        }
        int result=securityService.updateByPrimaryKey(fSecurity);
        if(result==1) {
            return ReturnResult.SUCCESS("修改成功");
        } else {
            return ReturnResult.FAILUER("修改失败");
        }
    }
    /**
     * 新增权限
     */
    @RequestMapping("security/addSecurity")
    @ResponseBody
    public ReturnResult addSecurity(
            @RequestParam(value="fparentid") Integer fparentid,
            @RequestParam(value="furl", required = false) String furl,
            @RequestParam(value="fdescription", required = false) String fdescription,
            @RequestParam(value="fname", required = false) String fname,
            @RequestParam(value="forder", required = false) Integer forder
    ){
        FSecurity fSecurity=new FSecurity();
        fSecurity.setFname(fname);
        fSecurity.setForder(forder);
        fSecurity.setFdescription(fdescription);
        fSecurity.setFurl(furl);
        fSecurity.setFparentid(fparentid);
        int result=securityService.insert(fSecurity);
        if(result==1) {
            return ReturnResult.SUCCESS("添加成功");
        } else {
            return ReturnResult.FAILUER("添加失败");
        }
    }

    /**
     * 删除权限
     */
    @RequestMapping("security/delSecurity")
    @ResponseBody
    public ReturnResult delSecurity(
            @RequestParam(value="fid") Integer fid
    ){
        int ccount=securityService.getChildCount(fid);
        if(ccount>0)
        {
            return ReturnResult.FAILUER("删除失败！请先删除此权限下的子权限");
        }
        else{
            int result=securityService.del(fid);
            if(result==1) {
                return ReturnResult.SUCCESS("删除成功");
            } else {
                return ReturnResult.FAILUER("删除失败");
            }
        }

    }

}
