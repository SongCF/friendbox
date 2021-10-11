package com.scys.friendbox.utils.template;

/**
 * 业务事件基础对象类
 */
public class BizEventBO {

    /** 业务事件码 */
    private String eventCode;

    /** 业务事件流水号 */
    private String eventSeqNo;

    /** 本次业务服务响应时长 */
    private long   responseTime;
    
    /** 业务事件处理结果 */
    private String eventResult;

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public String getEventSeqNo() {
        return eventSeqNo;
    }

    public void setEventSeqNo(String eventSeqNo) {
        this.eventSeqNo = eventSeqNo;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    public String getEventResult() {
        return eventResult;
    }

    public void setEventResult(String eventResult) {
        this.eventResult = eventResult;
    }
}
