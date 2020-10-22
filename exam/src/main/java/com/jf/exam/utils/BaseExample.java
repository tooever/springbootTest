package com.jf.exam.utils;

import tk.mybatis.mapper.entity.Example;

public class BaseExample extends Example {
    private Integer pageNum;
    private Integer pageSize;
    private boolean needPage;


    public Integer getPageNum() {
        return pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public boolean getNeedPage() {
        return needPage;
    }

    public BaseExample(Class<?> entityClass) {
        super(entityClass);
        this.needPage = false;
    }

    public BaseExample(Class<?> entityClass, Integer pageNum, Integer pageSize) {
        super(entityClass);
        this.needPage = true;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }


}
