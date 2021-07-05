package com.vnpay.model;

public class Pagination {
	private int pageNO;
	private int totalRecord;
	private int pageSize;
    public int getPageNO() {
        return pageNO;
    }
    public void setPageNO(int pageNO) {
        this.pageNO = pageNO;
    }
    public int getTotalRecord() {
        return totalRecord;
    }
    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
	
	
}
