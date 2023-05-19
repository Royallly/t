package com.softusing.BaiYunXiao.entity;

public class MyPage {
    private int thisPage;
    private int totalPage;
    private int pageSize;

    public int getThisPage() {
        return thisPage;
    }

    public void setThisPage(int thisPage) {
        this.thisPage = thisPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
