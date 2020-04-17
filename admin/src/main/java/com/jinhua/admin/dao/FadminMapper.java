package com.jinhua.admin.dao;


import com.jinhua.admin.entity.Fadmin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface FadminMapper {
    /**
     * 新增管理员
     */
    public void addFadmin(Fadmin Fadmin);

    /**
     * 删除管理员
     */
    public void delFadmin(Integer id);

    /**
     * 根据id修改管理员状态
     * @param id,state
     */
    public void updateByIdFadmin(Integer id, Integer state);

    /**
     * 修改管理员信息
     * @param Fadmin
     */
    public void updateFadmin(Fadmin Fadmin);

    /**
     * 根据ID查询管理员
     * @param name
     * @return
     */
    public Fadmin findByName(String name);

    /**
     * 为修改表单做回显
     */
    public Fadmin findById(Integer id);

    /**
     * 查询管理员集合
     */
    List<Fadmin> findFadminList(Fadmin fadmin);


    /**
     * 批量删除管理员
     */
    void batchDeleteFAdmin(List<Integer> list);
}
