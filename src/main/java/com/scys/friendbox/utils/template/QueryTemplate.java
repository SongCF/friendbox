package com.scys.friendbox.utils.template;

import com.scys.friendbox.utils.error.Result;
import org.springframework.stereotype.Service;

@Service
public class QueryTemplate {

    /**
     * 模板查询方法。实现接口中的action，即会按照本模板的执行顺序执行。
     * 
     * @param result
     * @param bizEventBO
     * @param action
     */
    public void query(final Result result, final BizEventBO bizEventBO, final HandleCallback action) {

        long startTime = System.currentTimeMillis();

        try {

            //1. 业务开始前，设置bizEvent业务对象
            {
                // 1.1由业务进行事件编码等设置
                action.setEventBeforeBiz();
            }

            // 2.参数检查
            {
                action.checkParams();
            }
            // 3.查询
            {
                action.process();
            }

            result.setSuccess(Boolean.TRUE);

        } catch (Exception e) {
            result.setSuccess(false);
        } finally {
            //设置本次服务响应时长
            long endTime = System.currentTimeMillis();
            bizEventBO.setResponseTime(endTime - startTime);

            //2. 收尾工作
        }
    }
}
