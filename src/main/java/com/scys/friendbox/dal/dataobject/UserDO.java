package com.scys.friendbox.dal.dataobject;

import com.scys.friendbox.biz.makefriends.model.UserInfo;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户数据模型
 */
@Data
@Entity
@DynamicUpdate
@Table(name="fb_user")
public class UserDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modify")
    private Date gmtModify;

    @Column(name = "user_info")
    private UserInfo userInfo;

    @Column(name = "cnt")
    private Integer cnt;

}