package com.jinhua.admin.dao;

import com.jinhua.admin.entity.FSecurity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FSecurityMapper {

    /**
     * 删除权限
     *
     * @param fid 权限id
     * @return 删除记录数
     */
    int deleteByPrimaryKey(Integer fid);

    /**
     * 添加权限
     *
     * @param record 权限实体
     * @return 插入记录数
     */
    int insert(FSecurity record);

    /**
     * 根据id查询权限
     *
     * @param fid 权限id
     * @return 权限实体
     */
    FSecurity selectByPrimaryKey(Integer fid);

    /**
     * 获得子权限数量
     *
     * @param fid 权限id
     * @return 权限实体
     */
    int getChildCount(Integer fid);

    /**
     * 查询所有的权限
     *
     * @return 权限列表
     */
    List<FSecurity> selectAll();

    /**
     * 根据id更新权限
     *
     * @param record 权限实体
     * @return 更新记录数
     */
    int updateByPrimaryKey(FSecurity record);

    /***** Admin ******/

    /**
     * 根据角色查询所以的权限
     *
     * @param froleid 角色id
     * @return 权限列表
     */
    List<FSecurity> findFSecurityList(@Param("froleid") int froleid);

}
