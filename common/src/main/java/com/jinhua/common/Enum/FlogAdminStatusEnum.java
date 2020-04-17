package com.jinhua.common.Enum;

/**
 * 管理员日志状态常量
 */
public class FlogAdminStatusEnum {

    /**
     * 登录
     */
    public static final Integer FADMIN_LOG_LOGIN = 1;
    /**
     * 添加操作
     */
    public static final Integer FADMIN_LOG_ADD = 2;
    /**
     * 修改操作
     */
    public static final Integer FADMIN_LOG_UPDATE = 3;
    /**
     * 删除操作
     */
    public static final Integer FADMIN_LOG_DELETE = 4;
    /**
     * 退出登录
     */
    public static final Integer FADMIN_LOG_LOGINOUT = 5;


    public static String getEnumString(int value) {
        String name = "";
        if (value == FADMIN_LOG_LOGIN) {
            name = "登录";
        } else if (value == FADMIN_LOG_ADD) {
            name = "添加";
        } else if (value == FADMIN_LOG_UPDATE) {
            name = "修改";
        } else if (value == FADMIN_LOG_DELETE) {
            name = "删除";
        } else if (value == FADMIN_LOG_LOGINOUT) {
            name = "退出";
        }
        return name;
    }


}
