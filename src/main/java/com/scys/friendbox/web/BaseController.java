package com.scys.friendbox.web;

import com.scys.friendbox.utils.error.Result;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 基础controller
 */
@RestController
public class BaseController {

    /**
     * 默认页面提示语key
     */
    protected static final String SUCCESS = "success";

    /**
     * 默认页面提示语DATA
     */
    protected static final String DATA = "data";

    /**
     * 默认页面提示语MESSAGE
     */
    protected static final String MESSAGE = "message";

    /**
     * 前端接口:总记录数为itemsCount
     */
    protected static final String ITEMS_COUNT = "itemsCount";

    /**
     * 前端接口:总记录数为itemsPerPage
     */
    protected static final String ITEMS_PER_PAGE = "itemsPerPage";

    /**
     * 前端接口:当前页为currentPage
     */
    protected static final String CURRENT_PAGE = "currentPage";

    /**
     * 前端接口:总页数数为totalPages
     */
    protected static final String TOTAL_PAGES = "totalPages";

    /**
     * 解析query string
     *
     * @param request http请求
     * @return 参数结果
     */
    protected final Map<String, Object> formatQueryPara(HttpServletRequest request) {

        //参数初始化
        Map<String, Object> requestParams = new HashMap<>();

        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = enu.nextElement();
            requestParams.put(paraName, request.getParameter(paraName));
        }

        return requestParams;
    }

    protected void saveResult(Result result, ModelMap modelMap) {
        modelMap.put(SUCCESS, result.isSuccess());
        if (result.isSuccess()) {
            modelMap.put(DATA, result.getResultObj());
        } else if (result.getMessage() != null) {
            modelMap.put(MESSAGE, result.getMessage() != null ? result.getMessage() : "");
        }
    }

}