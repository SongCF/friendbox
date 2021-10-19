package com.scys.friendbox.dal.enums;

/**
 * 用户性别
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

    /**
     * 获取
     * @param val
     * @return
     */
    public static UserGenderEnum getByCode(int val) {
        for (UserGenderEnum userGenderEnum : UserGenderEnum.values()) {
            if (userGenderEnum.getCode() == val) {
                return userGenderEnum;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }
}