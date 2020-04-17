package com.jinhua.admin.service;

import com.github.pagehelper.PageInfo;
import com.jinhua.admin.entity.Fsysargs;
import com.jinhua.common.bean.PageRequest;

import java.util.List;

/**
 * 管理系统服务层
 * Created by zhaorui on 2020/3/31
 */
public interface FsysargsService {

    /**
     * 添加用户系统(1)
     * @param fsysargs
     */
    void saveFsysargs(Fsysargs fsysargs);


    /**
     * 查询所有用户系统(1)
     * @return
     */
    List<Fsysargs> findAllFsysargs();


    /**
     * 根据Id查询用户系统(1)
     * @param fid
     * @return
     */
    Fsysargs findFsysargsById(Integer fid);


    /**
     * 根据id删除用户系统(1)
     * @param fsysargs
     */
     void deleteFsysargsById(Fsysargs fsysargs);



    /**
     * 修改用户系统(1)
     * @param fsysargs
     */
    void updateFsysargs(Fsysargs fsysargs);


    /**
     * 分页查询所有
     */
    PageInfo<Fsysargs> findFSysargsByfkey(PageRequest pageRequest, String fkey);

    Fsysargs findByKey(String fkey);

    /**
     * 加载数据金redis
     */
    void init();
}
