package com.jinhua.admin.service;


import com.jinhua.admin.entity.FRole;

import java.util.List;

/**
 * 角色
 *
 */
public interface FRoseService {

    /**
     * 添加角色
     *
     * @param record 角色实体
     * @return 插入记录数
     */
    int insert(FRole record);
    /**
     * 根据主键id查询角色
     *
     * @param fid 角色id
     * @return 角色实体
     */
    FRole selectByPrimaryKey(Integer fid);

    /**
     * 查询所以角色
     *
     * @return 记录列表
     */
    List<FRole> selectAll();

    /**
     * 更新角色信息
     *
     * @param record 角色实体
     * @return 更新记录数
     */
    int updateByPrimaryKey(FRole record);
}
