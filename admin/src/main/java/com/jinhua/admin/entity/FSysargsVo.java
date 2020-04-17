package com.jinhua.admin.entity;

import java.util.Objects;

public class FSysargsVo extends Fsysargs {
    private static final long serialVersionUID = 1L;

    private Integer page=1;
    private Integer size=10;

    public FSysargsVo() {
    }

    public FSysargsVo(Integer page, Integer size) {
        this.page = page;
        this.size = size;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FSysargsVo that = (FSysargsVo) o;
        return Objects.equals(page, that.page) &&
                Objects.equals(size, that.size);
    }

    @Override
    public int hashCode() {
        return Objects.hash(page, size);
    }
}
