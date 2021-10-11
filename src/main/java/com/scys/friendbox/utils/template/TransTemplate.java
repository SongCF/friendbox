package com.scys.friendbox.utils.template;

import com.scys.friendbox.utils.error.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class TransTemplate {

    @Autowired
    private TransactionTemplate transactionTemplate;

    /**
     * 操作执行
     *
     * @param result
     * @param bizEventBO
     * @param action
     */
    public void execute(final Result result, final BizEventBO bizEventBO,
                        final HandleCallback action) {
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

            // 3.业务前置操作
            {
                action.doPreAction();
            }

            // 4.开启事务
            {
                transactionTemplate.execute(new TransactionCallback<Object>() {
                    /**
                     *
                     * @see TransactionCallback#doInTransaction(TransactionStatus)
                     */
                    @Override
                    public Object doInTransaction(TransactionStatus status) {

                        // 5.锁记录
                        {
                            action.doLock();
                        }

                        // 6.操作处理
                        {
                            action.process();
                        }

                        return null;
                    }
                });
            }
            // 7.业务后置处理
            {
                action.doPostAction();
            }
            result.setSuccess(Boolean.TRUE);

            //8. 业务完成后，设置bizEvent业务对象
            {
                action.setEventAfterBiz();
            }

        } catch (Exception e) {
            result.setSuccess(false);
        } finally {
            //设置本次服务响应时长
            long endTime = System.currentTimeMillis();
            bizEventBO.setResponseTime(endTime - startTime);

            //3. 扫尾
        }
    }

}
