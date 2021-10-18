package com.scys.friendbox.session.security;

import com.scys.friendbox.session.AuthToken;
import com.scys.friendbox.session.RequestContext;
import com.scys.friendbox.session.RequestContextHolder;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;
import org.springframework.util.PathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

/**
 * 登录检查
 */
@Component
@Order(30001)
public class LoginCheckFilter implements Filter {

    /**
     * 租户检测白名单页面，在白名单内的页面不需要设置租户
     */
    @Value("#{'${acl.logincheck.whiteList}'.split(',')}")
    private List<String> loginCheckWhiteList = new ArrayList<>();

    /**
     * uri路径匹配器
     */
    public static PathMatcher pathMatcher = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        RequestContext currentRequestContext = RequestContextHolder.getCurrentRequestContext();
        AuthToken authToken = currentRequestContext.getAuthToken();

        // 未登录、不在白名单-->抛出异常
        if ((authToken == null) && (!isInTntInstWhitePageList((HttpServletRequest) request))) {
            throwUserNotLoginExp();
        }

        filterChain.doFilter(request, response);
    }

    /**
     * 当前请求是否属于租户白名单页面
     *
     * @param request
     * @return
     */
    protected boolean isInTntInstWhitePageList(HttpServletRequest request) {
        return isInWhitePageList(request, loginCheckWhiteList);
    }

    /**
     * 当前请求是否属于白名单页面
     *
     * @param request
     */
    private boolean isInWhitePageList(HttpServletRequest request, List<String> whitePageList) {
        //进行白名单地址的配置
        if (CollectionUtils.isEmpty(whitePageList)) {
            return false;
        }

        boolean result = false;
        String requestUri = request.getRequestURI();
        for (String whitePage : whitePageList) {
            if (StringUtils.isNotBlank(whitePage) && isRequestEqual(requestUri, whitePage)) {
                result = true;
                break;
            }
        }

        return result;
    }

    /**
     * 判断请求的uri与本地的uri是否相同
     *
     * @param requestUri 请求的uri
     * @return true - 相同的uri请求 不同的uri请求
     */
    public static boolean isRequestEqual(String requestUri, String existUri) {
        //对于仅关联操作码的应用资源，直接返回false，无需进行匹配
        if (StringUtils.isBlank(existUri)) {
            return false;
        }
        String orgUri = getUriWithOutExtraParas(requestUri);
        String existOrgUri = getUriWithOutExtraParas(existUri);
        //比较原始路径
        return pathMatcher.match(existOrgUri, orgUri);
    }

    /**
     * 根据uri获取不带参数的情况 如：/adb/adb.htm?a=b 会被处理为：/adb/adb.htm
     *
     * @param uri 请求的uri
     * @return 原始的uri
     */
    private static String getUriWithOutExtraParas(String uri) {
        int index = StringUtils.indexOf(uri, "?");
        if (index < 0) {
            return uri;
        }

        return StringUtils.substring(uri, 0, index);
    }

    public static void throwUserNotLoginExp() {
        throw new RuntimeException("NOT LOGIN (The current request resources doesn't login)");
    }
}