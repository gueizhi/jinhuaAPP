package com.jinhua.admin.dao;

import com.jinhua.admin.entity.FLogAdmin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 管理员日志 数据层
 */
@Mapper
public interface FLogAdminMapper {

    /**
     * 新增管理员日志
     *
     * @param fLogAdmin 管理员日志对象
     */
    void insertLogAdmin(FLogAdmin fLogAdmin);

    /**
     * 查询管理员日志集合
     *
     * @param fLogAdmin 管理员日志对象
     * @return 管理员日志集合
     */
    List<FLogAdmin> selectLogAdminList(FLogAdmin fLogAdmin);

    /**
     * 查询管理员日志详细
     *
     * @param fid 日志ID
     * @return 管理员日志对象
     */
    FLogAdmin selectLogAdminById(Integer fid);
}
