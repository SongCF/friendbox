package com.scys.friendbox.utils.error;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author dx
 * @version : Result.java, v 0.1 2021年10月11日 3:56 下午 dx Exp $
 */
public class Result<T> implements Serializable {
    private boolean success;
    private String  errorContext;
    private T       resultObj;

    public Result() {
    }

    public Result(boolean success, String errorContext, T resultObj) {
        this.success = success;
        this.errorContext = errorContext;
        this.resultObj = resultObj;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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