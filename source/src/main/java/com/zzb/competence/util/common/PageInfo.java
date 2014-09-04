package com.zzb.competence.util.common;

/**
 * Created by guanzhenxing on 2014-08-05.
 */
public class PageInfo {

    /** 显示的第一页 */
    private int start;
    /** 显示的最后一页 */
    private int last;
    /** 总页数 */
    private int totalPages;
    /** 页面显示的列数 */
    private int pageSize;
    /** 总列数 */
    private long totalElements;
    /** 显示的页数 */
    private int size;
    /** 当前页 */
    private int cur;

    private int left_off;
    private int right_off;

    public PageInfo() {

    }

    public PageInfo(int cur, int pageCnt, int totalPage, long totalElements) {
        this.cur = cur;
        this.size = pageCnt;
        this.totalPages = totalPage;
        this.totalElements = totalElements;

        this.left_off = this.size / 2 ;
        this.right_off = this.size - this.left_off -1;

        if(totalPage > pageCnt){
            start = cur <= left_off ? 1 :
                    (totalPage - cur > right_off ? cur - left_off : totalPage - left_off -right_off);
            last = cur <= left_off ? size :
                    (totalPage - cur > right_off ? cur + right_off : totalPage);
        }else{
            start = 1;
            last = totalPage;
        }

    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLast() {
        return last;
    }

    public void setLast(int last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCur() {
        return cur;
    }

    public void setCur(int cur) {
        this.cur = cur;
    }

    public int getLeft_off() {
        return left_off;
    }

    public void setLeft_off(int left_off) {
        this.left_off = left_off;
    }

    public int getRight_off() {
        return right_off;
    }

    public void setRight_off(int right_off) {
        this.right_off = right_off;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }
}
