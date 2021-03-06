package com.scys.friendbox.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * http请求上下文
 */
public class RequestContext {
    private String              appName;
    private String              requestUri;
    private String              referUri;
    private String              method;
    private Map<String, ?>      req;
    private HttpServletRequest  httpServletRequest;
    private HttpServletResponse httpServletResponse;
    private AuthToken           authToken;

    private String              invokeId;
    private Map<String, String> bizOpLogInfo = new HashMap();

    public RequestContext() {
    }

    public RequestContext(String appName, String requestUri, String referUri, String method, Map<String, ?> req) {
        this.appName = appName;
        this.requestUri = requestUri;
        this.referUri = referUri;
        this.method = method;
        this.req = req;
    }

    public String getRequestUri() {
        return this.requestUri;
    }


    public String getReferUri() {
        return this.referUri;
    }

    public String getMethod() {
        return this.method;
    }

    public Map<String, ?> getReq() {
        return this.req;
    }

    public String getInvokeId() {
        return this.invokeId;
    }

    public void setInvokeId(String invokeId) {
        this.invokeId = invokeId;
    }

    public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }

    public HttpServletRequest getHttpServletRequest() {
        return this.httpServletRequest;
    }

    public String getAppName() {
        return this.appName;
    }

    public HttpServletResponse getHttpServletResponse() {
        return this.httpServletResponse;
    }

    public void setHttpServletResponse(HttpServletResponse httpServletResponse) {
        this.httpServletResponse = httpServletResponse;
    }

    public AuthToken getAuthToken() {
        return authToken;
    }

    public void setAuthToken(AuthToken authToken) {
        this.authToken = authToken;
    }

    public void addBizOpLog(String key, String value) {
        if (key != null) {
            this.bizOpLogInfo.put(key, value);
        }
    }

    public Map<String, String> getBizOpLogInfo() {
        return this.bizOpLogInfo;
    }
}