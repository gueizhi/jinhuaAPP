package com.jinhua.common.Enum;

/**
 * 常量接口
 */
public class FadminStatusEnum  {
    /**
     * 管理员状态
     * 1启用
     * 2禁用
     */
    public static final Integer FADMIN_TYPE_OPEN=1;
    public static final Integer FADMIN_TYPE_CLOSE=2;

    public static String getEnumString(int value) {
        String name = "";
        if (value == FADMIN_TYPE_OPEN) {
            name = "正常";
        } else if (value == FADMIN_TYPE_CLOSE) {
            name = "禁用";
        }
        return name;
    }
}
