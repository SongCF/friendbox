package com.scys.friendbox.biz.makefriends.enums;

/**
 * 车房情况
 */
public enum HouseAndCarEnum {
    NONE_NONE(0, "无房无车"),
    NONE_CAR(2, "未购房&已购车"),
    HOUSE_NONE(3, "已购房&未购车"),
    HOUSE_CAR(4, "已购房&已购车"),
    ;

    private int code;
    private String dsc;

    HouseAndCarEnum(int code, String dsc) {
        this.code = code;
        this.dsc = dsc;
    }

    /**
     * 获取
     * @param val
     * @return
     */
    public static HouseAndCarEnum getByCode(int val) {
        for (HouseAndCarEnum userGenderEnum : HouseAndCarEnum.values()) {
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