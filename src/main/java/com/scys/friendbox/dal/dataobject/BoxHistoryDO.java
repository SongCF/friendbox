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
@Table(name="fb_box_history")
public class BoxHistoryDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "box_id", nullable = false)
    private Long boxId;

}