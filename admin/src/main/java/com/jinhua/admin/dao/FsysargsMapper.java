package com.jinhua.admin.dao;

import com.github.pagehelper.Page;
import com.jinhua.admin.entity.Fsysargs;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 管理系统 数据层
 * Created by zhaorui on 2020/3/31
 */
@Mapper
public interface FsysargsMapper {


    /**
     * 添加用户系统
     * @param fsysargs
     */
    void saveFsysargs(Fsysargs fsysargs);


    /**
     * 查询所有用户系统
     * @return
     */
    List<Fsysargs> findAllFsysargs();


    /**
     * 根据Id查询用户系统
     * @param fid
     * @return
     */
    Fsysargs findFsysargsById(Integer fid);


    /**
     * 根据id删除用户系统
     * @param fid
     */
    void deleteFsysargsById(Integer fid);


    /**
     * 修改用户系统
     * @param fsysargs
     */
    void updateFsysargs(Fsysargs fsysargs);


    /**
     * 分页查询用户系统
     * @param queryString
     * @return
     */
    Page<Fsysargs> selectByCondition(String queryString);

    /**
     * 根据fkey查询所有
     */
    List<Fsysargs> findFSysargsList(Fsysargs fsysargs);


    /**
     * 根据fkey查
     */
    Fsysargs findByKey(String fkey);
}
