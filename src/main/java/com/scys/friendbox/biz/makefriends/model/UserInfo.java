package com.scys.friendbox.biz.makefriends.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserInfo {
    //昵称
    private String name;
    //性别
    private int gender;
    //城市
    private String city;
    //出生日
    private Date birthday;
    //身高
    private int height;
    //体重
    private int weight;
    //职业
    private String profession;
    //年薪
    private int salary;
    //车房情况
    private int houseAndCar;
    //学历
    private int education;
    //聊天账号
    private String chatNum;
    //自我介绍
    private String dsc;
    //图片列表
    private List<String> pictureList;
}
