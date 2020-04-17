package com.jinhua.common.Enum;

public enum FAdminTypeEnum {
    USERS(1, "超级管理员"),
    WALLET(2, "普通管理员"),
    AUTHENTICATION(3, "临时管理员");

    private Integer code;
    private Object value;

    private FAdminTypeEnum(Integer code, Object value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
