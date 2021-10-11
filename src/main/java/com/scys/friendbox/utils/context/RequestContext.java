package com.scys.friendbox.utils.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author dx
 * @version : RequestContext.java, v 0.1 2021年10月11日 4:05 下午 dx Exp $
 */
public class RequestContext {
    private String              appName;
    private String              requestUri;
    private String              referUri;
    private String              method;
    private List<String>        requestMappingParams;
    private Map<String, ?>      req;
    private boolean             bodyContainsParameters;
    private HttpServletRequest  httpServletRequest;
    private HttpServletResponse httpServletResponse;
    private AuthToken authToken;

    private String              invokeId;
    private Map<String, String> bizOpLogInfo = new HashMap();

    public RequestContext() {
    }

    public RequestContext(String appName, String requestUri, String referUri, String method, List<String> requestMappingParams,
                          Map<String, ?> req) {
        this.appName = appName;
        this.requestUri = requestUri;
        this.referUri = referUri;
        this.method = method;
        this.requestMappingParams = requestMappingParams;
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

    public List<String> getRequestMappingParams() {
        return this.requestMappingParams;
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

    public boolean isBodyContainsParameters() {
        return this.bodyContainsParameters;
    }

    public void setBodyContainsParameters(boolean bodyContainsParameters) {
        this.bodyContainsParameters = bodyContainsParameters;
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