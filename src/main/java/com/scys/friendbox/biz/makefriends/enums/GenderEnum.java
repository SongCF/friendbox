package com.scys.friendbox.biz.makefriends.enums;

/**
 * 用户性别
 */
public enum GenderEnum {
    MALE(1, "男"),
    FEMALE(2, "女"),
    ;

    private int code;
    private String dsc;

    GenderEnum(int code, String dsc) {
        this.code = code;
        this.dsc = dsc;
    }

    /**
     * 获取
     * @param val
     * @return
     */
    public static GenderEnum getByCode(int val) {
        for (GenderEnum genderEnum : GenderEnum.values()) {
            if (genderEnum.getCode() == val) {
                return genderEnum;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }
}