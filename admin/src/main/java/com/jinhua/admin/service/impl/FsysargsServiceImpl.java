package com.jinhua.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jinhua.admin.dao.FsysargsMapper;
import com.jinhua.admin.entity.Fsysargs;
import com.jinhua.admin.service.FsysargsService;
import com.jinhua.common.bean.PageRequest;
import com.jinhua.common.tool.RedisTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 管理系统 服务层实现
 * Created by zhaorui on 2020/3/31
 */
@Service
public class FsysargsServiceImpl implements FsysargsService {

    @Autowired
    private FsysargsMapper fsysargsMapper;
    @Autowired
    private RedisTool redisTool;

    /**
     * 增加
     * @param fsysargs
     */
    @Override
    public void saveFsysargs(Fsysargs fsysargs) {
        fsysargs.setFcreatetime(new Date());
        fsysargsMapper.saveFsysargs(fsysargs);
        redisTool.setSystemArgs(fsysargs.getFkey(),fsysargs.getFvalue());
    }

    @Override
    public List<Fsysargs> findAllFsysargs() {
        return fsysargsMapper.findAllFsysargs();
    }

    @Override
    public Fsysargs findFsysargsById(Integer fid) {
        return fsysargsMapper.findFsysargsById(fid);
    }

    /**
     * 删除
     * @param fsysargs
     */
    @Override
    public void deleteFsysargsById(Fsysargs fsysargs) {
        Fsysargs fsysargsById = fsysargsMapper.findFsysargsById(fsysargs.getFid());
        fsysargsMapper.deleteFsysargsById(fsysargs.getFid());
        redisTool.del(fsysargsById.getFkey());

    }

    /**
     * 修改
     * @param fsysargs
     */
    @Override
    public void updateFsysargs(Fsysargs fsysargs) {
        Fsysargs fsysargsById = fsysargsMapper.findFsysargsById(fsysargs.getFid());
        fsysargsMapper.updateFsysargs(fsysargs);

        if (fsysargsById.getFkey().equals(fsysargs.getFkey())){
            redisTool.setSystemArgs(fsysargs.getFkey(),fsysargs.getFvalue());
        }else {
            redisTool.del(fsysargsById.getFkey());
            redisTool.setSystemArgs(fsysargs.getFkey(),fsysargs.getFvalue());
        }

    }

    /**
     * 分页+条件查询
     * @param pageRequest
     * @param fkey
     * @return
     */
    @Override
    public PageInfo<Fsysargs> findFSysargsByfkey(PageRequest pageRequest, String fkey) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum,pageSize);
        Fsysargs fsysargs = new Fsysargs();
        fsysargs.setFkey(fkey);
        List<Fsysargs> list = fsysargsMapper.findFSysargsList(fsysargs);
        return new PageInfo<Fsysargs>(list);
    }

    @Override
    public Fsysargs findByKey(String fkey) {
        Fsysargs fsysargs = fsysargsMapper.findByKey(fkey);
        return fsysargs;
    }

    @Override
    public void init() {
        List<Fsysargs> allFsysargs = fsysargsMapper.findAllFsysargs();
        for (Fsysargs sys : allFsysargs) {
            redisTool.setSystemArgs(sys.getFkey(),sys.getFvalue());
        }
    }


}
