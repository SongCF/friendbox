--vim /etc/my.cnf
--[client]
--default-character-set=utf8mb4
--[mysql]
--default-character-set=utf8mb4
--[mysqld]
--character-set-server=utf8mb4
--collation-server=utf8mb4_general_ci

CREATE DATABASE IF NOT EXISTS `friendbox` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
use friendbox;

CREATE TABLE IF NOT EXISTS fb_user (
    id BIGINT NOT NULL AUTO_INCREMENT  COMMENT '唯一标识' ,
    gmt_create DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
    gmt_modify DATETIME DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '更新时间' ,
    user_info VARCHAR(5000) COMMENT '盲盒信息' ,
    cnt INT DEFAULT 0   COMMENT '可用的抽取次数' ,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

CREATE TABLE IF NOT EXISTS fb_recharge (
    id BIGINT NOT NULL AUTO_INCREMENT  COMMENT '唯一标识' ,
    gmt_create DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
    gmt_modify DATETIME DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '更新时间' ,
    user_id BIGINT NOT NULL  COMMENT '用户id' ,
    money BIGINT NOT NULL  COMMENT '金额（分）' ,
    channel VARCHAR(32)    COMMENT '充值渠道' ,
    dsc VARCHAR(1024)    COMMENT '描述' ,
    PRIMARY KEY (id),
    KEY `idx_userid` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='充值表';

CREATE TABLE IF NOT EXISTS fb_box (
    id BIGINT NOT NULL AUTO_INCREMENT  COMMENT '唯一标识' ,
    gmt_create DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
    gmt_modify DATETIME DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '更新时间' ,
    user_id BIGINT NOT NULL  COMMENT '用户id' ,
    cnt INT NOT NULL  COMMENT '计数' ,
    box_data VARCHAR(5000) COMMENT '盲盒信息' ,
    PRIMARY KEY (id),
    KEY `idx_userid` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='盲盒表';

CREATE TABLE IF NOT EXISTS fb_box_history (
    id BIGINT NOT NULL AUTO_INCREMENT  COMMENT '唯一标识' ,
    gmt_create DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
    user_id BIGINT NOT NULL  COMMENT '用户id' ,
    box_id BIGINT NOT NULL   COMMENT '抽中的盲盒id' ,
    PRIMARY KEY (id),
    KEY `idx_userid_gmtcreate` (`user_id`, `gmt_create`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='盲盒已被获取表';

CREATE TABLE IF NOT EXISTS fb_suggest (
    id BIGINT NOT NULL AUTO_INCREMENT  COMMENT '唯一标识' ,
    gmt_create DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
    user_id BIGINT NOT NULL  COMMENT '用户id' ,
    msg VARCHAR(5000) NOT NULL  COMMENT '消息体' ,
    PRIMARY KEY (id),
    KEY `idx_userid` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='留言建议表';



