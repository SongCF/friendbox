package com.scys.friendbox.dal.params;

import lombok.Data;

import java.util.Date;

/**
 * 盲盒查询参数
 */
@Data
public class BoxQuery {
    private Date    birthdayBegin;
    private Date    birthdayEnd;
    private Integer gender;
    private String  city;
    private Integer salaryBegin;
}