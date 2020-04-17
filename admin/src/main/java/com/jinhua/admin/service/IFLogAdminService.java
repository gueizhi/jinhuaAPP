package com.jinhua.admin.service;

import com.github.pagehelper.PageInfo;
import com.jinhua.admin.entity.FLogAdmin;
import com.jinhua.common.bean.PageRequest;

import java.util.List;

/**
 * 管理员日志 服务层
 */
public interface IFLogAdminService {

    /**
     * 新增管理员日志
     *
     * @param fLogAdmin 管理员日志对象
     */
    void insertLogAdmin(FLogAdmin fLogAdmin);


    /**
     * 分页查询管理员日志集合
     *
     * @param pageRequest 分页对象
     * @param fLogAdmin   管理员日志对象
     * @return 管理员日志集合
     */
    PageInfo<FLogAdmin> selectLogAdminByPage(PageRequest pageRequest, FLogAdmin fLogAdmin);

    /**
     * 查询管理员日志集合
     * @param fLogAdmin
     * @return
     */
    List<FLogAdmin> selectLogAdminList(FLogAdmin fLogAdmin);

    /**
     * 查询管理员日志详细
     *
     * @param fid 日志ID
     * @return 管理员日志对象
     */
    FLogAdmin selectLogAdminById(Integer fid);

    /**
     * 导出excel操作excel
     * @param lists
     * @return
     */
    List<List<String>> changeExcel(List<FLogAdmin> lists);
}
