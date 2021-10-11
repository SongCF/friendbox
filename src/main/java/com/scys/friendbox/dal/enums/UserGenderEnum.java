package com.scys.friendbox.dal.enums;

/**
 *
 * @author dx
 * @version : UserGenderEnum.java, v 0.1 2021年10月11日 3:22 下午 dx Exp $
 */
public enum UserGenderEnum {
    MALE(1, "男"),
    FEMALE(2, "女");

    private int code;
    private String dsc;

    UserGenderEnum(int code, String dsc) {
        this.code = code;
        this.dsc = dsc;
    }

    public int getCode() {
        return code;
    }
}