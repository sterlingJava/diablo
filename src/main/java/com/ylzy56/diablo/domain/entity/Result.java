package com.ylzy56.diablo.domain.entity;

import lombok.Data;

@Data
public class Result {
    private boolean success;
    private String message;

    public Result() {
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
