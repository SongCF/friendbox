package com.scys.friendbox.utils.exception;

/**
 * 自定义业务异常
 */
public class BizException extends RuntimeException {

    /** 异常错误代码 */
    private ResultCode        code             = ResultCode.UN_KNOWN_EXCEPTION;

    /**
     * 创建一个<code>BizException</code>
     * 
     * @param code 错误码
     */
    public BizException(ResultCode code) {
        super(code.getDesc());
        this.code = code;
    }

    /**
     * 创建一个<code>BizException</code>
     * 
     * @param code 错误码
     * @param cause 异常
     */
    public BizException(ResultCode code, Throwable cause) {
        super(code.getDesc());
        this.code = code;
    }

    /**
     * 创建一个<code>BizException</code>
     * 
     * @param code 错误码
     * @param message 自定义错误信息
     */
    public BizException(ResultCode code, String message) {
        super(message);
        this.code = code;
    }

    /**
     * Constructs a new runtime exception with the specified detail message and cause.  <p>Note that the detail message associated with
     * {@code
     * cause} is <i>not</i> automatically incorporated in this runtime exception's detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method).
     * @param cause   the cause (which is saved for later retrieval by the {@link #getCause()} method).  (A <tt>null</tt> value is
     *                permitted,
     *                and indicates that the cause is nonexistent or unknown.)
     * @since 1.4
     */
    public BizException(ResultCode code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    /**
     * @see Throwable#toString()
     */
    @Override
    public final String toString() {
        String s = getClass().getName();
        String message = getLocalizedMessage();
        return s + ":" + code.getValue() + "[" + message + "].";
    }

    /**
     * @return Returns the code.
     */
    public ResultCode getCode() {
        return code;
    }

    /**
     * @param code The code to set.
     */
    public void setCode(ResultCode code) {
        this.code = code;
    }

}
