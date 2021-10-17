package com.scys.friendbox.session.authtoken;

import com.scys.friendbox.session.AuthToken;
import com.scys.friendbox.session.JsonMapper;
import com.scys.friendbox.session.RequestContext;
import com.scys.friendbox.session.RequestContextHolder;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * 初始化AuthToken的filter
 */
@Component
@Order(20001)
public class AuthTokenInitFilter implements Filter {

    @Value("${session.cookieName}")
    private String session_cookieName;

    @Value("${session.store}")
    private String session_store;

    private static final String SESSION_STORE_COOKIE = "cookie";
    private static final String SESSION_STORE_REDIS = "redis";

    /**
     * @param request
     * @param response
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain filterChain) throws IOException, ServletException {
        //初始化token
        initAuthToken(request, response);

        filterChain.doFilter(request, response);
    }

    public void initAuthToken(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {

        if (!checkSessionCookieName((HttpServletRequest) request, session_cookieName)) {
            //LogUtil.info(logger,"[Security controls]session_cookieName too long");
            ((HttpServletResponse) response).setStatus(400);
            return;
        }

        //LogUtil.info(logger, "[Security controls]Ready to perform the authToken initialization");

        RequestContext requestContext = new RequestContext();
        requestContext.setHttpServletRequest((HttpServletRequest) request);
        requestContext.setHttpServletResponse((HttpServletResponse) response);
        populateAuthTokenFromSession((HttpServletRequest) request, requestContext);
        RequestContextHolder.setCurrentRequestContext(requestContext);
    }

    /**
     * 从session中获取authtoken，然后设置到上下文仲
     *
     * @param request        当前http请求信息
     * @param requestContext 当前处理上下文信息
     */
    protected void populateAuthTokenFromSession(HttpServletRequest request, RequestContext requestContext) {
        AuthToken authToken = null;

        {
            String sessionID = decodeSessionIDFromCookie(request, session_cookieName);
            if (StringUtils.isEmpty(sessionID)) {
                return;
            }

            //本地session
            if (session_store != null && session_store.equalsIgnoreCase(SESSION_STORE_COOKIE)) {
                Cookie cookie = getCookie(request, sessionID);
                if (cookie != null) {
                    authToken = JsonMapper.fromJson(cookie.getValue(), AuthToken.class);
                }
                //if (authToken != null && authToken.getLoginUser() != null) {
                //    LogUtil.info(logger, "read authToken from session. loginUserId=" + authToken.getLoginUser().getId());
                //}
            }
            //服务端session
            else {
                authToken = readAuthTokenFromCache(sessionID);
                //LogUtil.info(logger, "read authToken from cache, loginUserId=" + loginUserId + ", authToken:" + authToken);
            }
        }
        requestContext.setAuthToken(authToken);
    }

    /**
     * 从cache中加载authToken
     *
     * @param loginUserId
     * @return
     */
    private AuthToken readAuthTokenFromCache(String loginUserId) {
        //TODO:
        throw new RuntimeException("unsupported");
    }

    private boolean checkSessionCookieName(HttpServletRequest request, String name) {
        if (name != null) {
            Cookie cookie = getCookie(request, name);
            if (cookie != null && cookie.getValue() != null) {
                byte[] keyBytes = cookie.getValue().getBytes(StandardCharsets.UTF_8);
                if (keyBytes.length > 250) {
                    return false;
                }
            }
        }
        return true;
    }

    public String decodeSessionIDFromCookie(HttpServletRequest request, String cookieName) {
        Cookie cookie = getCookie(request, cookieName);
        if (cookie != null) {
            String sessionID = StringUtils.trimToNull(cookie.getValue());
            if (sessionID != null) {
                return sessionID;
            }
        }
        return null;
    }

    /**
     * 根据cookie名获取cookie
     *
     * @param request
     * @param cookieName
     * @return
     */
    public static Cookie getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        if (ArrayUtils.isEmpty(cookies)) {
            return null;
        }
        for (Cookie cookie : cookies) {
            if (cookie == null) {
                continue;
            }
            if (StringUtils.equals(cookieName, cookie.getName())) {
                return cookie;
            }
        }

        return null;
    }

}
