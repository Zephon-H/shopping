package com.zephon.http;

import java.io.Serializable;

/**
 * @author Zephon
 * @version V1.0
 * @Package com.zephon.http
 * @date 2020/6/27 上午9:11
 * @Copyright ©
 */

public class Result implements Serializable {
    private boolean success;
    private String message;

    public Result(){}

    public Result(boolean success){
        this.success = success;
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
