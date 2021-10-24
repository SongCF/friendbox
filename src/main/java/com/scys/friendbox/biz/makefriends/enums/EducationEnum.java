package com.scys.friendbox.biz.makefriends.enums;

/**
 * 学历
 */
public enum EducationEnum {
    NONE(0, "无学历"),
    PRIMARY(1, "小学"),
    JUNIOR(2, "中学"),
    HIGH(3, "高中"),
    COLLEGE(4, "大专"),
    UNIVERSITY(5, "大学"),
    MASTER(6, "硕士"),
    DOCTOR(7, "博士"),
    ;

    private int code;
    private String dsc;

    EducationEnum(int code, String dsc) {
        this.code = code;
        this.dsc = dsc;
    }

    /**
     * 获取
     * @param val
     * @return
     */
    public static EducationEnum getByCode(int val) {
        for (EducationEnum userGenderEnum : EducationEnum.values()) {
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