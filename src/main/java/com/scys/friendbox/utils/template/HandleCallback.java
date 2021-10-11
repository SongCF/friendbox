package com.scys.friendbox.utils.template;

/**
 * 操作模板回调接口。<br>
 * 定义一个标准业务操作需要做的事情：
 * <li>业务开始前，设置bizEvent业务对象。主要是定义本次业务流程对应的标准业务事件。
 * <li>参数检查。检查参数是否满足本次业务流程需要。
 * <li>前置处理。 在执行业务操作之前，需要额外做的处理事情。
 * <li>锁处理。对某条记录进行操作时，需要锁定该记录，防止并发引起错误。
 * <li>操作处理。执行业务流程。
 * <li>后置处理。在业务操作完成之后，需要额外做的处理事情。
 * <li>业务结束后，设置bizEvent业务对象。主要是设置本次业务的事件流水号和执行结果等信息
 */
public interface HandleCallback {

    /** 业务开始前，设置bizEvent业务对象 */
    default void setEventBeforeBiz() {}

    /** 业务结束后，设置bizEvent业务对象 */
    default void setEventAfterBiz() {}

    /** 前置处理 */
    default void doPreAction() {}

    /** 后置处理 */
    default void doPostAction() {}

    /** 锁记录*/
    default void doLock() {}

    /** 参数检查 */
    default void checkParams() {}

    /** 操作处理 */
    void process();
}
