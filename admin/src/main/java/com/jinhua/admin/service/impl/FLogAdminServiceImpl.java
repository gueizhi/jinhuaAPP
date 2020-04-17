package com.jinhua.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jinhua.admin.dao.FLogAdminMapper;
import com.jinhua.admin.entity.FLogAdmin;
import com.jinhua.admin.service.IFLogAdminService;
import com.jinhua.common.bean.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理员日志 服务层处理
 */
@Service
public class FLogAdminServiceImpl implements IFLogAdminService {

    @Autowired
    private FLogAdminMapper fLogAdminMapper;

    /**
     * 新增管理员日志
     *
     * @param fLogAdmin 管理员日志对象
     */
    @Override
    public void insertLogAdmin(FLogAdmin fLogAdmin) {
        fLogAdminMapper.insertLogAdmin(fLogAdmin);
    }

    /**
     * 分页查询管理员日志集合
     *
     * @param pageRequest 分页对象
     * @param fLogAdmin   管理员日志对象
     * @return 管理员日志集合
     */
    @Override
    public PageInfo<FLogAdmin> selectLogAdminByPage(PageRequest pageRequest, FLogAdmin fLogAdmin) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<FLogAdmin> list = fLogAdminMapper.selectLogAdminList(fLogAdmin);
        return new PageInfo<FLogAdmin>(list);
    }

    @Override
    public List<FLogAdmin> selectLogAdminList(FLogAdmin fLogAdmin) {
        return fLogAdminMapper.selectLogAdminList(fLogAdmin);
    }

    /**
     * 查询管理员日志详细
     *
     * @param fid 日志ID
     * @return
     */
    @Override
    public FLogAdmin selectLogAdminById(Integer fid) {
        return fLogAdminMapper.selectLogAdminById(fid);
    }

    /**
     * 导出excel操作
     *
     * @param lists
     * @return
     */
    @Override
    public List<List<String>> changeExcel(List<FLogAdmin> lists) {

        List<List<String>> excelData = new ArrayList<List<String>>();

        List<String> head = new ArrayList<>();
        head.add("管理员");
        head.add("Ip地址");
        head.add("用户");
        head.add("类型");
        head.add("管理员类型");
        head.add("日志记录");
        head.add("操作时间");
        excelData.add(head);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < lists.size(); i++) {
            List<String> data = new ArrayList<>();
            data.add(lists.get(i).getFusername());
            data.add(lists.get(i).getFip());
            data.add(lists.get(i).getFname());
            data.add(lists.get(i).getFtype()+"");
            data.add(lists.get(i).getFadmintype()+"");
            data.add(lists.get(i).getFdata());
            data.add(sdf.format(lists.get(i).getFcreatetime()));
            excelData.add(data);
        }
        return excelData;
    }
}
