package com.jinhua.admin.service;


import com.github.pagehelper.PageInfo;
import com.jinhua.admin.entity.Fadmin;
import com.jinhua.common.bean.PageRequest;

import java.util.List;

public interface FadminService {
    public void addFadmin(Fadmin Fadmin);

    public void delFadmin(Integer id);

    public void updateByIdFadmin(Integer id, Integer state);

    public void updateFadmin(Fadmin Fadmin);

    public Fadmin findByName(String name);

    public Fadmin findById(Integer id);

    PageInfo<Fadmin> FindFadminByPageByfusername(PageRequest pageRequest, String fusername);


    /**
     * 批量删除管理员
     */
    void batchDeleteFAdmin(List<Integer> list);



}
