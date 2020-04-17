package com.jinhua.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jinhua.admin.dao.FadminMapper;
import com.jinhua.admin.entity.Fadmin;
import com.jinhua.admin.service.FadminService;
import com.jinhua.common.bean.PageRequest;
import com.jinhua.common.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FadminServiceImpl implements FadminService {

    @Autowired
    private FadminMapper fadminMapper;

    /**
     * 新增管理员
     * @param fadmin
     * @return
     */
    @Override
    public void addFadmin(Fadmin fadmin) {
        //controller传来的数据
        String fpassword = fadmin.getFpassword();

        //密码加密
        fadmin.setFpassword(Utils.MD5(fpassword));
        fadmin.setFstate(1);
        fadmin.setFcreatetime(new Date());
        fadminMapper.addFadmin(fadmin);

    }

    /**
     * 根据ID删除管理员
     * @param id
     */
    @Override
    public void delFadmin(Integer id) {
        fadminMapper.delFadmin(id);
    }

    /**
     * 根据id修改管理员状态
     * @param id
     * @param state
     */
    @Override
    public void updateByIdFadmin(Integer id, Integer state) {
        fadminMapper.updateByIdFadmin(id,state);
    }

    /**
     * 修改管理员信息
     * @param fadmin
     */
    @Override
    public void updateFadmin(Fadmin fadmin) {
        String fpassword = fadmin.getFpassword();
        if (fpassword==null){
            fadminMapper.updateFadmin(fadmin);
        }else {
            //密码加密
            fadmin.setFpassword(Utils.MD5(fpassword));
            fadminMapper.updateFadmin(fadmin);
        }
    }


    /**
     * 结合shiro做登录，结合shiro传过来的username查询
     * @param name
     * @return
     */
    @Override
    public Fadmin findByName(String name) {
         Fadmin fadmin = fadminMapper.findByName(name);
        return fadmin;
    }

    /**
     * 为修改表单做数据回显
     * @param id
     * @return
     */
    @Override
    public Fadmin findById(Integer id) {
        Fadmin fadmin = fadminMapper.findById(id);
        return fadmin;
    }




    /**
     * 分页查询集合
     * @param pageRequest 分页对象
     * @param
     * @return
     */
    @Override
    public PageInfo<Fadmin> FindFadminByPageByfusername(PageRequest pageRequest, String fusername) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        Fadmin fadmin = new Fadmin();
        fadmin.setFusername(fusername);
        List<Fadmin> list = fadminMapper.findFadminList(fadmin);
        return new PageInfo<Fadmin>(list);
    }

    /**
     * 批量删除
     * @param list
     */
    @Override
    public void batchDeleteFAdmin(List<Integer> list) {
        fadminMapper.batchDeleteFAdmin(list);
    }


}
