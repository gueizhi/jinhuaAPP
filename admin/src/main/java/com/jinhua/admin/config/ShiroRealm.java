package com.jinhua.admin.config;


import com.jinhua.admin.dao.FRoseMapper;
import com.jinhua.admin.dao.FSecurityMapper;
import com.jinhua.admin.entity.FRole;
import com.jinhua.admin.entity.FSecurity;
import com.jinhua.admin.entity.Fadmin;
import com.jinhua.admin.service.FadminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("shiroDbRealm")
public class ShiroRealm extends AuthorizingRealm {
    //@Autowired
    //private AdminDAO admindao;
    @Autowired
    private FRoseMapper fRoseMapper;
    @Autowired
    private FSecurityMapper fSecurityMapper;
    @Autowired
    private FadminService fadminService;


    /**
     * 授权方法，如果不设置缓存管理的话，需要访问需要一定的权限或角色的请求时会进入这个方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //Fadmin principal = (Fadmin) principals.getPrimaryPrincipal();
        //Set<String> roles = new HashSet<>();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        List<String> permissions = new ArrayList<String>();
        Fadmin fadmin=new Fadmin();
        if (SecurityUtils.getSubject().getSession().getAttribute("permissions") != null) {
            info = (SimpleAuthorizationInfo) SecurityUtils.getSubject().getSession().getAttribute("permissions");
        } else {
            // 获取当前登录的用户名
            String name = (String) super.getAvailablePrincipal(principals);
            fadmin.setFname(name);
            //获取admin，暂时测试先写死
            fadmin.setFroleId(1);

            if(fadmin!=null) {
                if(fadmin.getFroleId()!=null) {
                    // 查找角色
                    FRole fRole = fRoseMapper.selectByPrimaryKey(fadmin.getFroleId());
                    // 给当前用户设置角色
                    info.addRole(fRole.getFname());
                    List<FSecurity> set = fSecurityMapper.findFSecurityList(fRole.getFid());
                    for (FSecurity froleSecurity : set) {
                        permissions.add(froleSecurity.getFurl());
                    }
                }
            }
            // 给当前用户设置权限
            info.addStringPermissions(permissions);
            SecurityUtils.getSubject().getSession().setAttribute("permissions", info);
        }

        //return new SimpleAuthorizationInfo(roles);
        return info;
    }

    /**
     * 认证方法
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        UsernamePasswordToken userToken=(UsernamePasswordToken) token;
        //根据登录名查询用户，这里不用校验密码，因为密码的校验是交给shiro来完成的
        /*Fadmin admin=new Fadmin();
         //admindao.findByUserName(userToken.getUsername());

        //测试写死admin
        admin.setFusername("admin");
        admin.setFpassword(Utils.MD5("123456"));
        admin.setFname("管理员");*/
        Fadmin admin = fadminService.findByName(userToken.getUsername());

        if(admin == null) {
            throw new IncorrectCredentialsException("用户名或密码不正确");
        }

        //存在session里3600000
        SecurityUtils.getSubject().getSession().setTimeout(3600000);
        SecurityUtils.getSubject().getSession().setAttribute("login_admin", admin);
        return new SimpleAuthenticationInfo(admin.getFname(), admin.getFpassword(), admin.getFname());
    }
    public static void main(String[] args) {
        //算出盐值
        String credentials="1231111";
        String salt="刘霁萱";
        String hashAlgorithmName="MD5";
        int hashIterations=1024;
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        System.out.println(simpleHash);

    }

}
