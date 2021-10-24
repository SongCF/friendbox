package com.scys.friendbox.dal.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * 盲盒数据模型
 */
@Data
@Entity
@DynamicUpdate
@Table(name="fb_box")
public class BoxDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "gmt_create")
    private Date gmtCreate;

    @Column(name = "gmt_modify")
    private Date gmtModify;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "cnt", nullable = false)
    private Integer cnt;

    @Column(name = "box_data", nullable = false)
    private String boxData;

}