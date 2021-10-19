package com.scys.friendbox.dal.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * 历史盲盒模型
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