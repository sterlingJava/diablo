package com.ylzy56.diablo.domain.entity;

import lombok.Data;
import org.springframework.util.ObjectUtils;

public class Condition {
    private String keyword;
    private String status;
    private String date;
    private Integer pageNum;
    private Integer pageSize;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getPageNum() {
        if(ObjectUtils.isEmpty(pageNum)){
            return 1;//去除该属性的前后空格并进行非空非null判断
        }

        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        if(ObjectUtils.isEmpty(pageSize)){
            return 10;//去除该属性的前后空格并进行非空非null判断
        }
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
