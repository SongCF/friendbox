package com.scys.friendbox.biz.makefriends.model;

import lombok.Data;

import java.util.Date;

/**
 * 盲盒
 */
@Data
public class BoxModel {
    private long id;
    private Date gmtCreate;
    private Date gmtModify;
    private long userId;
    private int  cnt;
    private UserInfo userInfo;
}