package com.jinhua.admin.controller;

import com.github.pagehelper.PageInfo;
import com.jinhua.admin.entity.FAdminVo;
import com.jinhua.admin.entity.FRole;
import com.jinhua.admin.entity.Fadmin;
import com.jinhua.admin.entity.ReturnData;
import com.jinhua.admin.service.FRoseService;
import com.jinhua.admin.service.FadminService;
import com.jinhua.common.bean.PageRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("admin")
public class FAdminController {
    @Autowired
    private FadminService fadminService;
    @Autowired
    private FRoseService fRoseService;

    /**
     * 管理员页面全查询
     * @param fAdminVo
     * @return
     */
    @RequestMapping("/selectAll")
    @ResponseBody
    public ReturnData selectAll(FAdminVo fAdminVo){

        PageRequest pageRequest = new PageRequest();
        pageRequest.setPageNum(fAdminVo.getPage());
        pageRequest.setPageSize(fAdminVo.getSize());
        if (fAdminVo.getFusername()==""){
            fAdminVo.setFusername(null);
        }
        PageInfo<Fadmin> fadminPageInfo = fadminService.FindFadminByPageByfusername(pageRequest,fAdminVo.getFusername());
        List<FRole> fRoles = fRoseService.selectAll();
        List<Fadmin> list = fadminPageInfo.getList();
        for (Fadmin fadmin : list) {
            //将数据库中int类型数据装欢为String类型数据在前台展示
            if (fadmin.getFstate()==0){
                fadmin.setFstate_string("禁用");
            }else if (fadmin.getFstate()==1){
                fadmin.setFstate_string("启用");
            }

            if (fadmin.getFtype()==1){
                fadmin.setFtype_string("超级管理员");
            }else if (fadmin.getFtype()==2){
                fadmin.setFtype_string("系统管理员");
            }else if (fadmin.getFtype()==3){
                fadmin.setFtype_string("普通管理员");
            }

            for (FRole fRole : fRoles) {
                if (fRole.getFid()==fadmin.getFroleId()){
                    fadmin.setFroleid_string(fRole.getFname());
                }
            }

        }
        long total = fadminPageInfo.getTotal();
        ReturnData returnFAdmin = new ReturnData();

        returnFAdmin.setData(list);
        returnFAdmin.setCount(total);
        return returnFAdmin;
    }

    /**
     * 添加页面
     * @param fAdminVo
     * @return
     */
    @ResponseBody
    @RequestMapping("/addFAdmin")
    public ReturnData addFAdmin(FAdminVo fAdminVo){
        ReturnData returnData = new ReturnData();
        Fadmin fadmin = fadminService.findByName(fAdminVo.getFname());
        if (fadmin==null){
            fadminService.addFadmin(fAdminVo);
            returnData.setCode(200);
            returnData.setMsg("添加成功");
            return returnData;
        }else {
            returnData.setMsg("用户已存在");
            return returnData;
        }
    }

    /**
     * 管理员修改页面
     * @param fadmin
     * @return
     */
    @ResponseBody
    @RequestMapping("/editFAdmin")
    public ReturnData editFAdmin(Fadmin fadmin){
        ReturnData returnData = new ReturnData();
        if (fadmin.getFpassword()==""){
            fadmin.setFpassword(null);
        }
        Fadmin name = fadminService.findByName(fadmin.getFname());
        Fadmin name1 = fadminService.findById(fadmin.getFid());//查出当前用户的用户名

        if (name1.getFname().equals(fadmin.getFname())){
            fadminService.updateFadmin(fadmin);
            returnData.setCode(200);
            returnData.setMsg("修改成功");
            return returnData;
        }else {
            if (name==null){
                fadminService.updateFadmin(fadmin);
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
     * 角色下拉菜单显示
     * @return
     */
    @RequestMapping("/findAllFRole")
    @ResponseBody
    public ReturnData findAllFRole(){

        ReturnData returnData = new ReturnData();
        List<FRole> list = fRoseService.selectAll();
        returnData.setData(list);
        return returnData;
    }
    /**
     * 管理员跳转添加页面
     */
    @RequestMapping("/goAdd")
    public ModelAndView goAdd(){
        ModelAndView modelAndView = new ModelAndView();
        List<FRole> list = fRoseService.selectAll();
        modelAndView.addObject("fadminList",list);
        modelAndView.setViewName("admin/add");
        return modelAndView;
    }


    /**
     * 跳转到修改页面
     * @return
     */
    @RequestMapping("/goEdit")
    public ModelAndView goEdit(@RequestParam(value="fid") Integer fid){
        ModelAndView modelAndView = new ModelAndView();
        Fadmin fadmin = fadminService.findById(fid);
        modelAndView.addObject("fadmin",fadmin);
        List<FRole> list = fRoseService.selectAll();
        modelAndView.addObject("froleList",list);

        modelAndView.setViewName("admin/edit");
        return modelAndView;
    }

    /**
     * 操作栏单个删除
     */
    @RequestMapping("/deleteAdmin")
    @ResponseBody
    public ReturnData deleteAdmin(Fadmin fadmin){
        ReturnData returnData = new ReturnData();
        fadminService.delFadmin(fadmin.getFid());
        returnData.setCode(200);
        returnData.setMsg("删除成功");

        return returnData;
    }

    /**
     * 批量删除
     */
    @RequestMapping("/batchDeleteFAdmin")
    @ResponseBody
    public ReturnData batchDeleteFAdmin(FAdminVo fAdminVo){
        ReturnData returnData = new ReturnData();
        ArrayList<Integer> ids = new ArrayList<>();
        for (Integer fid : fAdminVo.getIds()) {
            ids.add(fid);
        }
        fadminService.batchDeleteFAdmin(ids);
        returnData.setMsg("删除成功");
        return returnData;

    }

}
