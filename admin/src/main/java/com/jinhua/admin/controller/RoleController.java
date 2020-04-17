package com.jinhua.admin.controller;

import com.jinhua.admin.entity.FRole;
import com.jinhua.admin.service.FRoseService;
import com.jinhua.common.tool.RedisTool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 角色管理
 */
@Controller
public class RoleController {
    //输出
    private static Logger logger= LoggerFactory.getLogger(Test.class);

    @Autowired
    private FRoseService roseService;
    @Autowired
    private RedisTool redisTool;


    /**
     * 角色列表
     */
    @RequestMapping("roleList")
    public ModelAndView roleList(){
        ModelAndView modelAndView = new ModelAndView();
        List<FRole> list= roseService.selectAll();
        modelAndView.addObject("theList",list);
        modelAndView.setViewName("role/roleList");
        return modelAndView;
    }
}
