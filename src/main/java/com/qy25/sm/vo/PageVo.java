package com.qy25.sm.vo;

import java.util.*;

public class PageVo<T> {

    private long total;

    private List<T> list;

    public long getTotal() {

        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageVo{" +
                "total=" + total +
                ", list=" + list +
                '}';
    }
}
