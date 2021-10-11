package com.scys.friendbox.dal.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 *
 * @author dx
 * @version : User.java, v 0.1 2021年10月10日 9:51 下午 dx Exp $
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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "birthday", nullable = false)
    private Date birthday;

    @Column(name = "gender", nullable = false)
    private Integer gender;

    @Column(name = "chat_number")
    private String chatNumber;

    @Column(name = "city")
    private String city;

    @Column(name = "profession")
    private String profession;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "dsc")
    private String dsc;

    @Column(name = "pictures")
    private String pictures;

    @Column(name = "cnt")
    private Integer cnt;

}