package com.jinhua.admin.controller;


import com.jinhua.common.tool.RedisTool;
import com.jinhua.common.util.Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 管理员登录、退出
 */
@Controller
public class LoginController {
    //输出
    private static Logger logger= LoggerFactory.getLogger(Test.class);

    @Autowired
    private RedisTool redisTool;


    /**
     * 退出登陆
     */
    @RequestMapping("/logout")
    public ModelAndView loginOut() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        Subject admin = SecurityUtils.getSubject();
        admin.getSession().removeAttribute("permissions");
        admin.logout();
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }

    @RequestMapping("/loginSub")
    public ModelAndView loginSub(
            @RequestParam(value = "username", required = true) String username,
            @RequestParam(value = "password", required = true) String password)
    {
        ModelAndView modelAndView = new ModelAndView();
        Subject currentUser = SecurityUtils.getSubject();
        if(!currentUser.isAuthenticated()) {
            UsernamePasswordToken token =new UsernamePasswordToken(username, Utils.MD5(password));
            try {
                //是否记住
                if(true) {
                    token.setRememberMe(true);
                }
                //3小时超时
                currentUser.getSession().setTimeout(3*60*60);
                currentUser.login(token);
            }catch (UnknownAccountException uae) {
                logger.info("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
            } catch (IncorrectCredentialsException ice) {
                logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
            } catch (LockedAccountException lae) {
                logger.info("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
            } catch (ExcessiveAttemptsException eae) {
                logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
            } catch (AuthenticationException ae) {
                //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
                logger.info("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
                ae.printStackTrace();
            }
        }
        modelAndView.setViewName("index");
        /*try {
            modelAndView.setViewName("index");
            //modelAndView.addObject("show","jinhua:"+redisTool.getString("testShow")+" --- "+tempTable.getTableCount()+ DateUtils.getTimeByHour(1).toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        return modelAndView;
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        try {
            if ((null != SecurityUtils.getSubject() && SecurityUtils.getSubject().isAuthenticated()) || SecurityUtils.getSubject().isRemembered()) {
                return "redirect:/";
            } else {
                System.out.println("调转登录页面");
                return "login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "login";
    }


    @RequestMapping("/theerror")
    public ModelAndView error(HttpServletRequest request) {
        System.out.println("错误");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }

    /**
     * 跳转用
     * @param url
     * @return
     */
    @RequestMapping("gotoURL")
    public ModelAndView gotoURL(@RequestParam(value = "url", required = true) String url) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(url);
        return modelAndView;
    }
    @RequestMapping("/toFAdminManager")
    public String toFAdmin(){
        return "admin";
    }
}
