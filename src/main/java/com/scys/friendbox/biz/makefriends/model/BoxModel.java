package com.scys.friendbox.biz.makefriends.model;

import lombok.Data;

import java.util.Date;

/**
 *
 */
@Data
public class BoxModel {

    private long id;
    private Date gmtCreate;
    private Date gmtModify;
    private long userId;
    private int  cnt;
    private int  weight;

    private String name;
    private Date   birthday;
    private int    gender;
    private String chatNumber;
    private String city;
    private String profession;
    private int    salary;
    private String dsc;
    private String pictures;
}