package com.ydlx.domain.vo;

import java.io.Serializable;

/**
 * Created by ydlx on 2017/5/30.
 */
public class PageRequestVO implements Serializable{

    /**当前页码*/
    private Integer currentPage;

    /**每页数据行数*/
    private Integer pageSize;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageRequestVO{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }
}
