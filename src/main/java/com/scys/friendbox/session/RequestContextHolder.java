package com.scys.friendbox.session;

/**
 * http请求线程上下文
 */
public class RequestContextHolder {

    /**
     * 匿名账号id
     */
    private static final String ANONYMOUS_USER_ID   = "-1";
    /**
     * 匿名账号名
     */
    private static final String ANONYMOUS_USER_NAME = "ANONYMOUS_USER";

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

    /**
     * 获取当前登录的用户信息，如果当前未登录，则创建默认的账号
     *
     * @return
     */
    public static OperatorDTO getWithAnonymousUser() {
        OperatorDTO loginUser = getLoginUser();
        if (loginUser == null) {
            loginUser = createDefaultUser();
        }

        return loginUser;
    }

    /**
     * 系统默认账号
     *
     * @return 默认账号
     */
    private static OperatorDTO createDefaultUser() {
        OperatorDTO operatorDTO = new OperatorDTO();
        operatorDTO.setId(ANONYMOUS_USER_ID);
        operatorDTO.setName(ANONYMOUS_USER_NAME);
        operatorDTO.setNickName(ANONYMOUS_USER_NAME);
        return operatorDTO;
    }

}