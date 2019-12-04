package com.ylzy56.diablo.domain.entity;

import lombok.Data;

import java.util.List;

@Data
public class PageResult {
    private long total;//总记录数
    private List rows;//当前页记录

    public PageResult(long total, List rows) {
        this.total = total;
        this.rows = rows;
    }
}
