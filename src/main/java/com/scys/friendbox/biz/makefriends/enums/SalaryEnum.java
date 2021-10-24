package com.scys.friendbox.biz.makefriends.enums;

/**
 * 年薪
 */
public enum SalaryEnum {
    BTW_0_10(0, "10万以内"),
    BTW_10_20(10, "10万~20万"),
    BTW_20_30(20, "20万~30万"),
    BTW_30_50(30, "30万~50万"),
    BTW_50_100(50, "50万~100万"),
    BTW_100_(100, "100万以上"),
    ;

    private int code;
    private String dsc;

    SalaryEnum(int code, String dsc) {
        this.code = code;
        this.dsc = dsc;
    }

    /**
     * 获取
     * @param val
     * @return
     */
    public static SalaryEnum getByCode(int val) {
        for (SalaryEnum userGenderEnum : SalaryEnum.values()) {
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