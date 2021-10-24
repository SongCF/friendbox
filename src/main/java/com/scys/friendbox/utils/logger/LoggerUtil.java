package com.scys.friendbox.utils.logger;

/**
 * 日志工具类
 */
public class LoggerUtil {

    /** 日志参数前缀 */
    private static final String LOG_PARAM_PREFIX = "(";

    /** 日志参数后缀 */
    private static final String LOG_PARAM_SUFFIX = ")";

    /**
     * get logger
     * @param name
     * @return
     */
    public static Logger getLogger(String name) {
        return new Logger(name);
    }

    /**
     * get logger by class
     * @param clazz
     * @return
     */
    public static Logger getLogger(Class clazz) {
        return getLogger(clazz.getName());
    }

    /**
     * debug日志输出
     *
     * @param logger
     * @param message
     */
    public static void debug(Logger logger, Object message) {
        if (logger.logger.isDebugEnabled()) {
            logger.logger.debug(message + getLogKey());
        }
    }

    /**
     * 生成<font color="blue">通知</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     *
     * @param logger
     * @param obj
     */
    public static void debug(Logger logger, Object... obj) {
        if (logger.logger.isDebugEnabled()) {
            Object[] objs = (Object[]) obj;
            String message = "";
            for (int i = 0; i < objs.length; i++) {
                message = message + objs[i] + ",";
            }
            message = message.substring(0, message.lastIndexOf(","));
            logger.logger.debug(message + getLogKey());
        }
    }

    /**
     * info日志输出
     *
     * @param logger
     * @param message
     */
    public static void info(Logger logger, Object message) {
        if (logger.logger.isInfoEnabled()) {
            logger.logger.info(message + getLogKey());
        }
    }

    /**
     * 生成<font color="blue">通知</font>级别日志<br>
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     *
     * @param logger
     * @param obj
     */
    public static void info(Logger logger, Object... obj) {
        if (logger.logger.isInfoEnabled()) {
            Object[] objs = (Object[]) obj;
            String message = "";
            for (int i = 0; i < objs.length; i++) {
                message = message + objs[i] + ",";
            }
            message = message.substring(0, message.lastIndexOf(","));
            logger.logger.info(message + getLogKey());
        }
    }

    /**
     * warn日志输出
     *
     * @param logger
     * @param message
     */
    public static void warn(Logger logger, Object message) {
        logger.logger.warn(message + getLogKey());
    }

    /**
     * warn日志输出
     *
     * @param logger
     * @param message
     * @param t
     */
    public static void warn(Logger logger, Object message, Throwable t) {
        logger.logger.warn(message + getLogKey(), t);
    }

    /**
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     *
     * @param logger
     * @param obj
     */
    public static void warn(Logger logger, Throwable t, Object... obj) {
        Object[] objs = (Object[]) obj;
        String message = "";
        for (int i = 0; i < objs.length; i++) {
            message = message + objs[i] + ",";
        }
        message = message.substring(0, message.lastIndexOf(","));
        logger.logger.warn(message + getLogKey(), t);
    }

    /**
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     *
     * @param logger
     * @param obj
     */
    public static void warn(Logger logger, Object... obj) {
        Object[] objs = (Object[]) obj;
        String message = "";
        for (int i = 0; i < objs.length; i++) {
            message = message + objs[i] + ",";
        }
        message = message.substring(0, message.lastIndexOf(","));
        logger.logger.warn(message + getLogKey());
    }

    /**
     * error日志输出
     *
     * @param logger
     * @param message
     */
    public static void error(Logger logger, Object message) {
        logger.logger.error(message + getLogKey());
    }

    /**
     * 可处理任意多个输入参数，并避免在日志级别不够时字符串拼接带来的资源浪费
     *
     * @param logger
     * @param obj
     */
    public static void error(Logger logger, Object... obj) {
        Object[] objs = (Object[]) obj;
        String message = "";
        for (int i = 0; i < objs.length; i++) {
            message = message + objs[i] + ",";
        }
        message = message.substring(0, message.lastIndexOf(","));
        logger.logger.error(message + getLogKey());
    }

    /**
     * error日志输出
     *
     * @param logger
     * @param message
     * @param t
     */
    public static void error(Logger logger, Object message, Throwable t) {
        logger.logger.error(message + getLogKey(), t);
    }

    /**
     * 得到LogKey
     *
     * @return
     */
    public static String getLogKey() {
        return "";
    }
}
