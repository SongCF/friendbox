package com.scys.friendbox.dal.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

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
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

}