package com.scys.friendbox.utils.error;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * 通用biz层返回对象
 */
public class Result<T> implements Serializable {
    private boolean success;
    private String  message;
    private String  errorContext;
    private T       resultObj;

    public Result() {
    }

    public Result(boolean success, String message, String errorContext, T resultObj) {
        this.success = success;
        this.message = message;
        this.errorContext = errorContext;
        this.resultObj = resultObj;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorContext() {
        return this.errorContext;
    }

    public void setErrorContext(String errorContext) {
        this.errorContext = errorContext;
    }

    public T getResultObj() {
        return this.resultObj;
    }

    public void setResultObj(T resultObj) {
        this.resultObj = resultObj;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}