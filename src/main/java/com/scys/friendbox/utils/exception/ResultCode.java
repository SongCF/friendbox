package com.scys.friendbox.utils.exception;

/**
 * 结果码
 */
public enum ResultCode {

    // ---------------------- 系统异常 ------------------------- //

    /** 未知异常 */
    UN_KNOWN_EXCEPTION("000", ErrorLevels.ERROR, ErrorTypes.SYSTEM, "未知异常"),

    /** 系统异常 */
    SYSTEM_ERROR("001", ErrorLevels.ERROR, ErrorTypes.SYSTEM, "系统异常"),

    /** 递归次数超过最大数 */
    RECURISVE_ERROR("002", ErrorLevels.ERROR, ErrorTypes.SYSTEM, "超过最大递归次数"),

    /** 导入出错 */
    IMPORT_ERROR("003", ErrorLevels.ERROR, ErrorTypes.SYSTEM, "导入出错"),

    /** 导出出错 */
    EXPORT_ERROR("004", ErrorLevels.ERROR, ErrorTypes.SYSTEM, "导出出错"),

    /** 对象为空 */
    PARAMETER_IS_NULL("101", ErrorLevels.ERROR, ErrorTypes.BIZ, "入参为空"),
    /** 枚举为空 */
    ENUM_IS_NULL("102", ErrorLevels.ERROR, ErrorTypes.BIZ, "枚举为空"),
    /** 集合为空 */
    COLLECTION_IS_NULL("103", ErrorLevels.ERROR, ErrorTypes.BIZ, "参数集合为空"),
    /** 字符串内容不一致 */
    STRING_NOT_EQUALS("104", ErrorLevels.ERROR, ErrorTypes.BIZ, "字符串内容不一致"),
    /** 数字小<=0 */
    PARAMETER_IS_LESS_EQUES_ZERO("105", ErrorLevels.ERROR, ErrorTypes.BIZ,
            "数字小于等于0"),
    /** 参数必须为数字*/
    PARAMETER_IS_NOT_NUMBER("107", ErrorLevels.ERROR, ErrorTypes.BIZ,
            "必须为大于0的数字"),
    /** 入参不合法 */
    PARAMETER_IS_ILLEGAL("108", ErrorLevels.ERROR, ErrorTypes.BIZ, "入参不合法"),
    /** 字符串长度超过限制 */
    LENGTH_LIMIT("120", ErrorLevels.ERROR, ErrorTypes.BIZ, "长度超过限制"),

    /** 参数必须为数字*/
    OPERATE_IS_NULL("121", ErrorLevels.ERROR, ErrorTypes.BIZ, "没有权限进行此操作"),

    /** 不能小于0 */
    PARAMETER_IS_LESS_THAN_ZERO("146", ErrorLevels.ERROR, ErrorTypes.BIZ,
            "数字小于0"),

    /** 数字小=0 */
    PARAMETER_IS_ZERO("144", ErrorLevels.ERROR, ErrorTypes.BIZ, "数字等于0"),



    // ---------------------- 业务异常 ------------------------- //

    /** 可用次数小于0 */
    USER_CNT_NOT_ENOUGH("10001", ErrorLevels.ERROR, ErrorTypes.BIZ, "可用次数小于0"),


    ;

    public interface ErrorLevels {
        String INFO = "1";
        String WARN = "3";
        String ERROR = "5";
        String FATAL = "7";
    }
    public interface ErrorTypes {
        String SYSTEM = "0";
        String BIZ = "1";
        String THIRD_PARTY = "2";
    }

    private String value;
    private String errorLevel;
    private String errorType;
    private String desc;

    /**
     * @param value
     * @param errorLevel
     * @param errorType
     * @param desc
     */
    ResultCode(String value, String errorLevel, String errorType, String desc) {
        this.value = value;
        this.errorLevel = errorLevel;
        this.errorType = errorType;
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getErrorLevel() {
        return errorLevel;
    }

    public void setErrorLevel(String errorLevel) {
        this.errorLevel = errorLevel;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
