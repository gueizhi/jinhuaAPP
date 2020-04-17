package com.jinhua.admin.service;

import com.jinhua.admin.entity.FSecurity;
import java.util.List;

/**
 * 权限
 *
 */
public interface FSecurityService {

    /**
     * 添加权限
     *
     * @return 插入记录数
     */
    int insert(FSecurity security);
    /**
     * 根据主键id查询权限
     *
     * @param fid 权限id
     * @return 角色实体
     */
    FSecurity selectByPrimaryKey(Integer fid);

    /**
     * 查询所有权限
     *
     * @return 记录列表
     */
    List<FSecurity> selectAll();

    /**
     * 更新权限信息
     *
     * @return 更新记录数
     */
    int updateByPrimaryKey(FSecurity security);

    /**
     * 删除权限
     *
     * @return 更新记录数
     */
    int del(Integer fid);

    /**
     * 获得子权限数量
     *
     * @return 更新记录数
     */
    int getChildCount(Integer fid);
}
