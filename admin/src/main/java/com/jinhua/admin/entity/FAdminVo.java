package com.jinhua.admin.entity;

import java.util.Arrays;
import java.util.Objects;

public class FAdminVo extends Fadmin {
    private static final long serialVersionUID = 1L;


    private Integer page=1;
    private Integer size=10;
    private Integer[] ids;

    public FAdminVo() {
    }

    public FAdminVo(Integer page, Integer size, Integer[] ids) {
        this.page = page;
        this.size = size;
        this.ids = ids;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer[] getIds() {
        return ids;
    }

    public void setIds(Integer[] ids) {
        this.ids = ids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FAdminVo fAdminVo = (FAdminVo) o;
        return Objects.equals(page, fAdminVo.page) &&
                Objects.equals(size, fAdminVo.size) &&
                Arrays.equals(ids, fAdminVo.ids);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(page, size);
        result = 31 * result + Arrays.hashCode(ids);
        return result;
    }
}
