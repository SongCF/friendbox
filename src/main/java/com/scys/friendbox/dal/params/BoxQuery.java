package com.scys.friendbox.dal.params;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 盲盒查询参数
 */
@Data
public class BoxQuery {
//    性别 生日 身高 体重  年薪  车房  学历
    private int gender;
    private Date    birthdayBegin;
    private Date    birthdayEnd;
    private int heightBegin;
    private int heightEnd;
    private int weightBegin;
    private int weightEnd;
    private int salaryBegin;
    private int houseAndCarBegin;
    private int educationBegin;
}