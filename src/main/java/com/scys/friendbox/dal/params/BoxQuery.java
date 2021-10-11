package com.scys.friendbox.dal.params;

import lombok.Data;

import java.util.Date;

/**
 * @author dx
 * @version : BoxQuery.java, v 0.1 2021年10月11日 4:26 下午 dx Exp $
 */
@Data
public class BoxQuery {
    private Date    birthdayBegin;
    private Date    birthdayEnd;
    private Integer gender;
    private String  city;
    private Integer salaryBegin;
}