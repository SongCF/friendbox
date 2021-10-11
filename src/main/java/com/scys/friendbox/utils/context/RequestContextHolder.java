package com.scys.friendbox.utils.context;

/**
 * @author dx
 * @version : RequestContextHolder.java, v 0.1 2021年10月11日 4:04 下午 dx Exp $
 */
public class RequestContextHolder {

    private static ThreadLocal<RequestContext> currentRequestContext = new ThreadLocal();

    public RequestContextHolder() {
    }

    public static void setCurrentRequestContext(RequestContext requestContext) {
        currentRequestContext.set(requestContext);
    }

    public static RequestContext getCurrentRequestContext() {
        return (RequestContext) currentRequestContext.get();
    }

    public static OperatorDTO getLoginUser() {
        RequestContext requestContext = (RequestContext) currentRequestContext.get();
        if (requestContext == null) {
            return null;
        } else {
            AuthToken authToken = requestContext.getAuthToken();
            return authToken == null ? null : authToken.getLoginUser();
        }
    }

}