package com.scys.friendbox.utils.exception;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * 数据校验工具，校验出错返回异常
 */
public class AssertUtil {

    /**
     * 判断字符串不为空
     *
     * @param object
     * @param message
     */
    public static void notBlank(String object, String message) {
        if (StringUtils.isBlank(object)) {
            throw new BizException(ResultCode.PARAMETER_IS_NULL, message);
        }
    }

    /**
     * 判断字符串内容是否一致
     *
     * @param str1    字符串1
     * @param str2    字符串2
     * @param message 错误信息
     */
    public static void notEquals(String str1, String str2, String message) {
        if (!StringUtils.equals(str1, str2)) {

            throw new BizException(ResultCode.STRING_NOT_EQUALS, message);
        }
    }

    /**
     * 判断传入的collection是否为null或者空集合，如果为null或者空集合，抛出<code>BizException</code>
     *
     * @param collection
     */
    public static void notEmpty(Collection collection, String message) {
        if (CollectionUtils.isEmpty(collection)) {

            throw new BizException(ResultCode.COLLECTION_IS_NULL, message);
        }
    }

    /**
     * 判断入参数字。如果小于等于0，认为是空参数，抛出参数空异常。
     *
     * @param number
     * @param message 提示信息
     * @throws BizException 如果对象为空
     */
    public static void isLessEqualZero(long number, String message) {
        if (number <= 0) {

            throw new BizException(ResultCode.PARAMETER_IS_LESS_EQUES_ZERO, message);
        }
    }

    /**
     * 小于0
     *
     * @param number
     * @param message
     */
    public static void isLessZero(long number, String message) {
        if (number < 0) {

            throw new BizException(ResultCode.PARAMETER_IS_LESS_THAN_ZERO, message);
        }
    }

    /**
     * 判断入参数字。如果等于0，认为是空参数，抛出参数空异常。 文章排序值更新时校验，排除0
     *
     * @param number
     * @param message 提示信息
     * @throws BizException 如果对象为空
     */
    public static void isZero(long number, String message) {
        if (number == 0) {

            throw new BizException(ResultCode.PARAMETER_IS_ZERO, message);
        }
    }

    /**
     * 判断入参字符串是否为数字且是否大于0。如果小于等于0，认为是空参数，抛出参数空异常。
     *
     * @param number
     * @param message 提示信息
     * @throws BizException 如果对象为空
     */
    public static void isLessEqualZero(String number, String message) {
        if (NumberUtils.toInt(number) <= 0) {

            throw new BizException(ResultCode.PARAMETER_IS_LESS_EQUES_ZERO, message);
        }
    }

    /**
     * 判断传入的参数是否为数字 str含有非数字abc:抛出异常 纯数字123：正常
     *
     * @param str
     * @param message
     */
    public static void isNotNumber(String str, String message) {
        if (!StringUtils.isNumeric(str)) {
            throw new BizException(ResultCode.PARAMETER_IS_NOT_NUMBER, message);
        }
    }

    /**
     * 判断传入的参数是否为数字 str含有非数字abc:抛出异常 纯数字123：正常
     *
     * @param message
     */
    public static void isNotNumber(long number, String message) {
        if (number <= 0) {

            throw new BizException(ResultCode.PARAMETER_IS_NOT_NUMBER, message);
        }
    }

    /**
     * 判断表达是否正确
     *
     * @param expression
     * @param message
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new BizException(ResultCode.OPERATE_IS_NULL, message);
        }
    }

    /**
     * 本方法供拿到结果后抛出指定异常使用。 判断参数合法性检查结果，如果为false，则抛出异常。
     *
     * @param message 提示信息
     * @throws BizException 如果参数为false
     */
    public static void paramLegal(boolean isLegal, String message) {
        if (!isLegal) {
            throw new BizException(ResultCode.PARAMETER_IS_ILLEGAL, message);
        }
    }

    /**
     * 检查参数对象不为空
     *
     * @param object  对象
     * @param message 提示信息
     * @throws BizException 如果对象为空
     */
    public static void paramNotNull(Object object, String message) {
        if (object == null) {
            throw new BizException(ResultCode.PARAMETER_IS_NULL, message);
        }
    }

    /**
     * 判断入参字符串不为空
     *
     * @param object
     * @param message 提示信息
     * @throws BizException 如果对象为空
     */
    public static void paramNotEmpty(String object, String message) {
        if (StringUtils.isEmpty(object)) {
            throw new BizException(ResultCode.PARAMETER_IS_NULL, message);
        }
    }

    /**
     * 判断入参字符串不为空白
     *
     * @param object
     * @param message 提示信息
     * @throws BizException 如果对象为空
     */
    public static void paramNotBlank(String object, String message) {
        if (StringUtils.isBlank(object)) {
            throw new BizException(ResultCode.PARAMETER_IS_NULL, message);
        }
    }

    /**
     * 判断入参数字。如果小于等于0，认为是空参数，抛出参数空异常。
     *
     * @param number
     * @param message 提示信息
     * @throws BizException 如果对象为空
     */
    public static void isMoreThanZero(long number, String message) {
        if (number <= 0) {
            throw new BizException(ResultCode.PARAMETER_IS_NULL, message);
        }
    }

    /**
     * 判断入参字符串是否为数字且是否大于0。如果小于等于0，认为是空参数，抛出参数空异常。
     *
     * @param number
     * @param message 提示信息
     * @throws BizException 如果对象为空
     */
    public static void isMoreThanZero(String number, String message) {
        if (NumberUtils.toInt(number) <= 0) {
            throw new BizException(ResultCode.PARAMETER_IS_NULL, message);
        }
    }

    /**
     * 判断传入字符串{@code object}的实际长度，不超过指定{@code length}，
     * <p>
     * 如果 传入字符串{@code object}不为空，并且实际长度超过指定{@code length}，
     * <p>
     * 则抛出{@code CsconfigException(ConfigResultCodeEnum.ILLEGAL_ARGUMENT.getCode(), message)}异常
     *
     * @param object  传入字符串
     * @param length  指定长度
     * @param message 错误信息
     * @throws BizException 如果{@code object}为空，或者实际长度大于{@code length}，则抛出异常
     */
    public static void isLessThanLength(String object, int length, String message) {
        if (object != null && object.trim().length() > length) {
            throw new BizException(ResultCode.PARAMETER_IS_ILLEGAL, message);
        }
    }

    /**
     * 本方法供拿到结果后抛出指定异常使用。 判断参数合法性检查结果，如果为false，则抛出异常。
     *
     * @throws BizException 如果参数为false
     */
    public static void paramLegal(boolean isLegal) {
        if (!isLegal) {
            throw new BizException(ResultCode.PARAMETER_IS_ILLEGAL);
        }
    }

    /**
     * 判断字符串不为空
     *
     * @param object
     * @param message
     */
    public static void notBlank(String object, ResultCode resultCode, String message) {
        if (StringUtils.isBlank(object)) {

            throw new BizException(resultCode, message);
        }
    }

    /**
     * 判断传入的object是否为null，如果为null，抛出<code>BizException</code>
     *
     * @param object
     * @param message
     */
    public static void notNull(Object object, String message) {
        if (object == null) {

            throw new BizException(ResultCode.PARAMETER_IS_NULL, message);
        }
    }

    /**
     * 判断传入的object是否为null，如果为null，抛出<code>BizException</code>
     *
     * @param object
     * @param resultCode
     * @param message
     */
    public static void notNull(Object object, ResultCode resultCode, String message) {
        if (object == null) {

            throw new BizException(resultCode, message);
        }
    }

    /**
     * 判断传入的collection是否为null或者空集合，如果为null或者空集合，抛出<code>BizException</code>
     *
     * @param collection
     * @param resultCode
     */
    public static void notEmpty(Collection collection, ResultCode resultCode, String message) {
        if (CollectionUtils.isEmpty(collection)) {
            throw new BizException(resultCode, message);
        }
    }

    /**
     * 判断字符串长度是否超过限制
     *
     * @param str     字符串
     * @param len     字符串长度边界值
     * @param message 提示信息
     */
    public static void lenLimit(String str, int len, String message) {
        if (str.length() > len) {
            throw new BizException(ResultCode.LENGTH_LIMIT, message);
        }
    }

    /**
     * 判断传入的参数是否为数字 str含有非数字abc:抛出异常 纯数字123：正常
     *
     * @param str
     * @param resultCode
     * @param message
     */
    public static void isNotNumber(String str, ResultCode resultCode, String message) {
        if (!StringUtils.isNumeric(str)) {
            throw new BizException(resultCode, message);
        }
    }

    /**
     * 判断对象是否为null，如果为null返回“” 不抛出异常
     *
     * @param obj
     * @return
     */
    public static Object isNullStr(Object obj) {
        if (obj == null) {
            return "";
        } else {
            return obj;
        }
    }

}
