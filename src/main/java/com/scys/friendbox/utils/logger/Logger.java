package com.scys.friendbox.utils.logger;

import org.slf4j.LoggerFactory;

/**
 *  Logger统一接口
 */
public class Logger {

    /**
     * logger
     */
    public org.slf4j.Logger logger;

    /**
     * getter
     * @param name
     * @return
     */
    public Logger(String name) {
        this.logger = LoggerFactory.getLogger(name);
    }

}